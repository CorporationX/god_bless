package school.faang.task61578;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class User {
    private String name;
    private String assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        assignedRole = house.assignRole();
        log.info("Роль найдена: {}", assignedRole);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Освобождение роли: {}", assignedRole);
        leaveHouse(house);
    }

    public void leaveHouse(House house) {
        house.releaseRole(assignedRole);
        log.info("Роль {} успешно освобождена", assignedRole);
    }
}
