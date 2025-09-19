package school.faang.bjs2_90299;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<Role> roles = new ArrayList<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public synchronized Role assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("Interrupted due to error", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        return roles.remove(0);
    }

    public synchronized void releaseRole(Role role) {
        roles.add(role);
        notifyAll();
    }
}
