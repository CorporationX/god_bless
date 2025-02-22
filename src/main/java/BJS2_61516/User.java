package BJS2_61516;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            log.info("{} joined the house with role {}", name, assignedRole);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            if (assignedRole != null && this.house != null) {
                house.releaseRole(assignedRole);
                log.info("{} left the house", name);
                assignedRole = null;
                this.house = null;
            }
        }
    }
}
