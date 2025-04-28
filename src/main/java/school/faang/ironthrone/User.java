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
        this.house = house;
        assignedRole = house.assignRole();
        log.info("{} got the role {}", name, assignedRole);
    }

    public void leaveHouse(House house) {
        if (house != null && assignedRole != null) {
            house.releaseRole(assignedRole);
            log.info("{} has left the role {}", name, assignedRole);
            assignedRole = null;
        }
    }
}