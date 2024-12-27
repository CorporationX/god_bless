package school.faang.task_48837;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
public class House {
    @Getter
    private final Object lock;

    private final Set<Role> availableRoles;
    private int availableRoleCount;

    public House(@NonNull Set<Role> roles) {
        this.availableRoles = new HashSet<>(roles);
        this.availableRoleCount = roles.size();

        this.lock = new Object();
    }

    public Optional<Role> addRole() {
        synchronized (availableRoles) {
            Optional<Role> result;
            if (availableRoles.isEmpty()) {
                result = Optional.empty();
            } else {
                Role role = availableRoles.iterator().next();
                availableRoles.remove(role);
                availableRoleCount = availableRoles.size();
                result = Optional.ofNullable(role);
            }

            return result;
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
