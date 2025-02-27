package school.faang.task_63401;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<String> roles;

    public House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                log.info("Все роли заняты, поток ожидает освобождения...");
                wait();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании роли: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        String role = roles.remove(0);
        log.info("Роль '{}' назначена.", role);
        return role;
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        log.info("Роль '{}' освобождена.", role);
        notifyAll();
    }
}


