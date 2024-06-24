package faang.school.godbless.synchronization.game_of_trones;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
public class House {
    private String name;
    private final List<Role> availableRoles;
    private int countActiveRole;
    private final int maxCountRole;

    public House(String name, List<Role> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        this.countActiveRole = availableRoles.size();
        this.maxCountRole = availableRoles.size();
    }

    public synchronized void addRole(Role role) {
        if (maxCountRole > 0) {
//            availableRoles.remove(role);
            countActiveRole--;
        } else {
            log.info("All roles are filled, please wait.");
        }
    }

    public synchronized void removeRole(Role role) {
        if (countActiveRole < maxCountRole) {
//            availableRoles.add(role);
            countActiveRole++;
        }
    }
}


