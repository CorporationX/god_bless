package school.faang.iron_thron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class House {
    private final Map<Role, Boolean> rolesAvailabilityMap;

    public void assignRole(User user) throws InterruptedException {
        log.debug("Thread: {}, executing assignRole()", Thread.currentThread().getName());
        Objects.requireNonNull(user, "user cannot be null");
        Objects.requireNonNull(rolesAvailabilityMap, "roles cannot be null");
        synchronized (rolesAvailabilityMap) {
            Optional<Map.Entry<Role, Boolean>> availableRole;
            while ((availableRole = getAvailableRole(rolesAvailabilityMap)).isEmpty()) {
                log.debug("Thread: {}, waiting for role", Thread.currentThread().getName());
                rolesAvailabilityMap.wait();
            }
            Role roleToAssign = availableRole.get().getKey();
            user.setAssignedRole(roleToAssign);
            rolesAvailabilityMap.put(roleToAssign, false);
            log.info("Thread: {}, assigned role: {} for {}", Thread.currentThread().getName(),
                    user.getAssignedRole(), user);
        }
    }

    public void releaseRole(User user) {
        log.debug("Thread: {}, executing releaseRole()", Thread.currentThread().getName());
        synchronized (rolesAvailabilityMap) {
            if (isRoleAssigned(user)) {
                Role assignedRole = user.getAssignedRole();
                rolesAvailabilityMap.put(assignedRole, true);
                rolesAvailabilityMap.notifyAll();
                user.setAssignedRole(null);
                log.debug("Role: {} released", assignedRole);
            } else {
                log.info("Thread: {}, No Role for user has been assigned yet", Thread.currentThread().getName());
            }
        }
    }

    private boolean isRoleAssigned(User user) {
        return user.getAssignedRole() != null;
    }

    private Optional<Map.Entry<Role, Boolean>> getAvailableRole(Map<Role, Boolean> roles) {
        log.debug("Thread: {}, available roles = {}", Thread.currentThread().getName(), roles);
        return roles.entrySet().stream()
                .filter(Map.Entry::getValue)
                .findFirst();
    }
}
