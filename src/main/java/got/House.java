package got;

import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class House {
    private final Set<String> availableRoles;

    public House(Set<String> roles) {
        if (roles == null || roles.isEmpty()) {
            throw new IllegalArgumentException("Roles set must not be null or empty");
        }
        this.availableRoles = new HashSet<>(roles);
    }

    public synchronized String assignRole() throws InterruptedException {
        while (availableRoles.isEmpty()) {
            log.info("No roles available, waiting...");
            wait();
        }
        String role = availableRoles.iterator().next();
        availableRoles.remove(role);
        log.info("Assigned role: {}", role);
        return role;
    }

    public synchronized void releaseRole(String role) {
        if (role == null) {
            throw new IllegalArgumentException("Role must not be null");
        }
        availableRoles.add(role);
        log.info("Released role: {}", role);
        notifyAll();
    }
}
