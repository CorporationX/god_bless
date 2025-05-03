package school.faang.bjs2_73250;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private House house;
    private String assignedRole;

    public void joinHouse(House house) {
        synchronized (house) {
            this.house = house;
            assignedRole = house.assignRole();
            log.info("Player {} is now has {} role", name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                log.info("Player {} leaves house and releases role {}", name, assignedRole);
                house.releaseRole(assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}