package BJS2_61516;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class House {
    private final List<String> roles = new ArrayList<>(List.of("Lord", "Knight", "Mage"));

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Interrupted while waiting for roles to be assigned", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}
