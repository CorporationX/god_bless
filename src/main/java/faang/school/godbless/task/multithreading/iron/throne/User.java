package faang.school.godbless.task.multithreading.iron.throne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
@Getter
@RequiredArgsConstructor
public class User {
    private final Random random = new Random();
    private final String name;
    private House house;
    private Role role;

    public void joinHouse(House house) {
        synchronized (house) {
            while (house.getNumberOfAvailableRoles() < 1) {
                log.info("В доме {} нет свободных ролей, пользователь {} в ожидании", house.getName(), this.name);
                sleep(house);
                log.info("Пользователь {} выходит из режима ожидания", this.name);
            }
            join(house);
        }
    }

    private void sleep(House house) {
        synchronized (house) {
            try {
                house.wait();
            } catch (InterruptedException exception) {
                log.error("Interrupted exception {}", exception.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    private void join(House house) {
        synchronized (house) {
            List<Role> availableRoles = house.getRoles();
            this.role = availableRoles.get(random.nextInt(availableRoles.size()));
            house.removeRole(this.role);
            this.house = house;
            log.info("Пользователь {} получил доступ к дому {}, и случайным подбором выбрал роль: {}",
                    this.name, house.getName(), this.role);
        }
    }

    public void leaveHouse() {
        synchronized (this.house) {
            house.addRole(this.role);
            log.info("Пользователь {} покинул дом {}", this.name, house.getName());
        }
        this.role = null;
        this.house = null;
    }
}
