package school.faang.bjs2_73288;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private final String name;
    private Role assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        assignedRole = house.assignRole();
        log.info("User '{}' joined house with the role {}", name, assignedRole);
    }

    public void leaveHouse(House house) {
        house.releaseRole(assignedRole);
        log.info("User '{}' left house with the role {}", name, assignedRole);
        assignedRole = null;
    }
}
