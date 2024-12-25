package school.faang.task_48837;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class House {
    private final Set<Role> availableRoles;

    private int availableRoleCount;

    public House(@NonNull Set<Role> roles) {
        this.availableRoles = new HashSet<>(roles);
        this.availableRoleCount = roles.size();
    }

    public Role addRole() {
        synchronized (availableRoles) {
            Role role = availableRoles.iterator().next();
            availableRoles.remove(role);
            availableRoleCount = availableRoles.size();
            return role;
        }
    }

    public void removeRole(@NonNull Role role) {
        synchronized (availableRoles) {
            availableRoles.add(role);
            availableRoleCount = availableRoles.size();
        }
    }

    public int getAvailableRoleCount() {
        synchronized (availableRoles) {
            return availableRoleCount;
        }
    }

}
