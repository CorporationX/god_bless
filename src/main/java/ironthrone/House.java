package ironthrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
class House {
    private static final String MSG_ALL_ROLES_TAKEN = "All roles in '{}' are occupied. Waiting for a free slot...";
    private static final String MSG_ROLE_ASSIGNED = "Role '{}' assigned to a player.";
    private static final String MSG_ROLE_RELEASED = "Role '{}' has been released.";
    private static final String MSG_EXCEPTION_AVAILABLE_ROLE = "No available roles found!";
    private static final String MSG_EXCEPTION_INTERRUPTION = "Waiting was interrupted!";

    @Getter
    private final String name;
    private final Set<String> availableRoles;
    private final Set<String> occupiedRoles = new HashSet<>();

    public House(String name, Set<String> roles) {
        this.name = name;
        this.availableRoles = new HashSet<>(roles);
    }

    public synchronized String assignRole() {
        while (true) {
            if (!rolesOccupied()) {
                return assignAvailableRole();
            }
            log.info(MSG_ALL_ROLES_TAKEN, name);
            try {
                log.info("[{}] waiting for a free role...", Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(MSG_EXCEPTION_INTERRUPTION, e);
            }
        }
    }

    private boolean rolesOccupied() {
        return occupiedRoles.size() == availableRoles.size();
    }

    private String assignAvailableRole() {
        return availableRoles.stream()
                .filter(occupiedRoles::add)
                .findFirst()
                .map(role -> {
                    log.info(MSG_ROLE_ASSIGNED, role);
                    return role;
                })
                .orElseThrow(() -> new RuntimeException(MSG_EXCEPTION_AVAILABLE_ROLE));
    }

    public synchronized void releaseRole(String role) {
        if (role != null && occupiedRoles.remove(role)) {
            log.info(MSG_ROLE_RELEASED, role);
            log.info("[{}] notifying waiting threads...", Thread.currentThread().getName());
            notifyAll();
        } else {
            log.warn("[{}] failed to release role '{}' because it was not occupied",
                    Thread.currentThread().getName(), role);
        }
    }
}
