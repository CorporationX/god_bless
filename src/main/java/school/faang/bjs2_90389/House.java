package school.faang.bjs2_90389;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {

    private final List<Roles> roles = new ArrayList<>();

    public synchronized void assignRole(Roles role) {
        while (roles.contains(role)) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.warn("{} has been interrupted during waiting time", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }
        roles.add(role);
        log.info("Role {} assigned. Current roles: {}", role, roles);
    }

    public synchronized void releaseRole(Roles role) {
        if (roles.contains(role)) {
            roles.remove(role);
            log.info("Role {} release. Current roles: {}", role.name(), roles);
            notifyAll();
        } else {
            log.warn("Role {} not found", role.name());
        }
    }
}
