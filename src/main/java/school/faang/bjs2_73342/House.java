package school.faang.bjs2_73342;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class House {
    private final String name;
    private final Set<Role> roles;
    private final Map<Role, User> assignedRoles = new HashMap<>();

    public House(String name, Set<Role> roles) {
        this.name = name;
        this.roles = roles;
    }

    public synchronized Role assignRole(User user) {
        log.info("{} walks in the house {} and wants a role", user.getName(), name);
        while (assignedRoles.keySet().containsAll(roles)) {
            log.info("{} waiting because there are no roles.", user.getName());
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new ThreadStoppageException(ex);
            }
        }
        Role freeRole = getFreeRole();
        assignedRoles.put(freeRole, user);
        log.info("{} got the part: {}", user.getName(), freeRole);
        return freeRole;
    }

    private Role getFreeRole() {
        return roles.stream()
                .filter(role1 -> !assignedRoles.containsKey(role1))
                .findAny()
                .orElseThrow(RoleNotFoundException::new);
    }

    public synchronized void releaseRole(User user) {
        if (!assignedRoles.containsValue(user)) {
            log.warn("{} trying to free up a role in someone else's house", name);
            return;
        }
        log.info("{} frees up the role: {}", user.getName(), user.getAssignedRole());
        assignedRoles.remove(user.getAssignedRole());
        this.notifyAll();
    }

    public synchronized void logRemainingAssignments() {
        if (!assignedRoles.isEmpty()) {
            log.warn("There are role assignments left unfinished:");
            assignedRoles.forEach((role, user) ->
                    log.warn("Role {} user occupied {}", role, user.getName()));
        }
    }
}
