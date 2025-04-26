package school.faang.bjs2_73193;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class User {

    private final String name;
    private Role assignedRole;

    public void joinHouse(House house) {
        log.info("{} trying to aquire a role", name);
        assignedRole = house.assignRole();
        log.info("New role assigned -> {}, to {}", assignedRole.toString(), name);
    }

    public void leaveHouse(House house) {
        log.info("{} releasing a role ({})", name, assignedRole.toString());
        house.releaseRole(assignedRole);
    }
}