package school.faang.ironthrone;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class House {
    private final List<Role> availableRoles;

    public synchronized Role assignRole() {
        while (availableRoles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Interrupted exception: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException("Operation failed", e);
            }
        }
        Role role = availableRoles.remove(0);
        return role;
    }

    public synchronized void releaseRole(Role role) {
        availableRoles.add(role);
        notifyAll();
    }
}
