package school.faang.sprint.third.iron;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class House {
    private final Set<Role> roles = new HashSet<>();
    private final Object lock = new Object();

    public void assignRole(Role role, User user) {

        synchronized (lock) {
            while (roles.contains(role)) {
                try {
                    log.info("Role {} already assigned to", role);
                    lock.wait();
                } catch (InterruptedException e) {
                    log.error("ASD{}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
            roles.add(role);
            log.info("Assigning role {} to {}", role, user.getName());
        }

    }

    public void releaseRole(Role role) {
        synchronized (lock) {
            log.info("Role {} released", role);
            roles.remove(role);
            lock.notifyAll();
        }
    }
}
