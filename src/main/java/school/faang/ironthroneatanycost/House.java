package school.faang.ironthroneatanycost;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class House {
    private final List<Role> availableRoles;

    public synchronized Role assignRole() {
        while (availableRoles.isEmpty()) {
            try {
                log.info("Нет свободных ролей. Ожидайте.");
                availableRoles.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Произошла ошибка: {}", e.getMessage());
            }
        }
        return availableRoles.remove(0);
    }

    public void releaseRole(Role role) {
        synchronized (availableRoles) {
            availableRoles.add(role);
            availableRoles.notifyAll();
        }
    }
}
