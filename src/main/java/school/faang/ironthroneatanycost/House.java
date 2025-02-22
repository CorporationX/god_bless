package school.faang.ironthroneatanycost;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class House {
    private final List<String> availableRoles = new ArrayList<>(Arrays.asList("Воин", "Мастер", "Стратег"));

    public synchronized String assignRole() {
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

    public void releaseRole(String role) {
        synchronized (availableRoles) {
            availableRoles.add(role);
            availableRoles.notifyAll();
        }
    }
}
