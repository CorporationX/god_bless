package school.faang.bjs2_81980;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public synchronized void joinHouse(House house) {
        this.assignedRole = house.assignRole();
        this.house = house;
        log.info("{} присоединился к дому с ролью {}", name, assignedRole);
    }

    public synchronized void leaveHouse() {
        if (house != null && assignedRole != null) {
            house.releaseRole(assignedRole);
            log.info("{} покидает дом, освобождая роль {}", name, assignedRole);
            this.assignedRole = null;
            this.house = null;
        }
    }
}
