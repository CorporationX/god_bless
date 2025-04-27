package school.faang.theirontroneatanycost;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class House {
    private final Set<Role> availableRoles;
    private final Set<Role> assignedRoles = new HashSet<>();

    public void assignRole(@NonNull Role role) {
        if (!availableRoles.contains(role)) {
            throw new IllegalArgumentException("This role is not available!");
        } else if (assignedRoles.contains(role)) {
            log.info("Thread is waiting for the role assignment...");

        }
        assignedRoles.add(role);
    }

    public void releaseRole(@NonNull Role role) {
        if (!assignedRoles.contains(role)) {
            throw new IllegalArgumentException("This role is not assigned!");
        }
        assignedRoles.remove(role);
    }

    public boolean isRoleAssigned(Role role) {
        return assignedRoles.contains(role);
    }
}
