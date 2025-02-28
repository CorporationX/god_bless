package school.faang.task61578;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final Object lock = new Object();
    private final List<String> roles = new ArrayList<>(List.of("Lord", "Mage", "Knight"));

    public String assignRole() {
        synchronized (lock) {
            if (roles.isEmpty()) {
                try {
                    log.info("Свободных ролей нет, ожидание...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Ошибка при ожидании потоков: {}", e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            return roles.remove(0);
        }
    }

    public void releaseRole(String role) {
        synchronized (lock) {
            roles.add(role);
            lock.notify();
        }
    }
}
