package school.faang.bjs2_81972;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class House {
    private final List<String> roles;

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании роли: ", e);
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
