package school.faang.task_48868;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private Optional<House> connectedHouse = Optional.empty();
    private Role selectedRole;

    public void joinHouse(@NonNull House house) {
        if (connectedHouse.isPresent()) {
            leaveHouse();
        }

        synchronized (house) {
            selectRole(house.getAvailableRoles());
            while (!house.getCurrentAvailableRoles().contains(selectedRole)) {
                try {
                    log.info("{} ждёт роль {} в доме {}", name, selectedRole, house);
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Ошибка ожидания роли: {}", e.getMessage());
                    return;
                }
            }
            log.info("{} подключился к {} с ролью {}", name, house, selectedRole);
            connectedHouse = Optional.of(house);
            house.reserveRole(selectedRole);
        }
    }

    public void leaveHouse() {
        connectedHouse.ifPresent(house -> {
            synchronized (house) {
                log.info("{} покидает {}", name, house);
                house.releaseRole(selectedRole);
            }
        });
        connectedHouse = Optional.empty();
    }

    private void selectRole(List<Role> availableRoles) {
        int randomIndex = ThreadLocalRandom.current().nextInt(availableRoles.size());
        selectedRole = availableRoles.get(randomIndex);
    }
}