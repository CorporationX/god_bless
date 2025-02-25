package school.faang.task_61521;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<String> roles = new ArrayList<>();

    public House(List<String> initialRoles) {
        roles.addAll(initialRoles); // Инициализация ролей
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
                log.info("ждем свободную роль");
            } catch (InterruptedException e) {
                log.warn("Ошибка при ожидании роли: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                return null; // Возвращаем null, если поток прерван
            }
        }
        String assignedRole = roles.remove(0);
        log.info("роль выдана: " + assignedRole);
        return assignedRole;
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        log.info("роль-" + role + " освободила место");
        notifyAll(); // Уведомляем ожидающие потоки
    }
}

