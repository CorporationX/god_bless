package school.faang.task61578;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class User {
    private static final int ROLE_USAGE_TIME_MS = 1000;
    private String name;
    private String assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        assignedRole = house.assignRole();
        log.info("Роль найдена: {}", assignedRole);
        try {
            Thread.sleep(ROLE_USAGE_TIME_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
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
