package school.faang.bjs2_92400;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class User {
    private String name;
    private String assignedRole;

    public void joinHouse(House house) {
        try {
            house.assignRole(this);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        log.info("Пользователь {} присоединился к {} как {}", name, house.getName(), assignedRole);
    }

    public void leaveHouse(House house) {
        house.releaseRole(this);
        log.info("Пользователь {} покинул {}", name, house.getName());
    }
}
