package school.faang.ironthrone;

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
            this.house = house;
            assignedRole = house.assignRole();
            log.info("{} got the role {}", name, assignedRole);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                try {
                    house.releaseRole(assignedRole);
                    log.info("{} has left the role {}", name, assignedRole);
                } finally {
                    assignedRole = null;
                    house = null;
                }
            }
        }
    }
}