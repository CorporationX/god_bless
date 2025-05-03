package school.faang.bjs2_73250;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class House {
    private final List<String> availableRoles;

    public synchronized String assignRole() {
        while (availableRoles.isEmpty()) {
            try {
                log.info("There is no available role. Please wait...");
                wait();
            } catch (InterruptedException e) {
                log.error("Interrupted exception with message {} was thrown during waiting", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return availableRoles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        availableRoles.add(role);
        notify();
    }
}