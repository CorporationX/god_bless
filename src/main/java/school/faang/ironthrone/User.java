package school.faang.ironthrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class User {

    private final String name;
    private RoleType assignedRole;

    public User(String name) {
        this.name = name;
        this.assignedRole = null;
    }

    public void joinHouse(House house) {
        assignedRole = house.assignRole();
        log.info("{} присвоена роль {}", name, assignedRole);
    }

    public void leaveHouse(House house) {
        log.info("{} освобожден от роли {}", name, assignedRole);
        house.releaseRole(assignedRole);
        assignedRole = null;
    }
}
