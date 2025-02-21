package school.faang.bjs2_61502;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;
import java.util.Set;

@Slf4j
public class House {
    private final Set<Role> availableRoles = EnumSet.of(Role.LORD, Role.KNIGHT, Role.MAGE);

    public synchronized Role assignRole() throws InterruptedException {
        while (availableRoles.isEmpty()) {
            log.info("All roles are occupied, waiting...");
            wait();
        }
        Role assignedRole = availableRoles.iterator().next();
        availableRoles.remove(assignedRole);
        log.info("Role {} assigned", assignedRole);
        return assignedRole;
    }

    public synchronized void releaseRole(Role role) {
        availableRoles.add(role);
        log.info("Role {} released", role);
        notifyAll();
    }
}