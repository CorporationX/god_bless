package school.faang.bjs2_90460;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private List<String> roles = new ArrayList<>();
    private final Object lock = new Object();

    public String assignRole() {
        synchronized (lock) {
            while (roles.isEmpty()) {
                log.info("Пользователь ждет роль");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Ошибка ожидания потока");
                }
            }
            log.info("Пользователь получил роль {}", roles.get(0));
            return roles.remove(0);
        }
    }

    public void releaseRole(User user) {
        synchronized (lock) {
            if (user.getAssignRole() == null || user.getAssignRole().isBlank()) {
                log.error("У пользователя нет роли! Чтобы снять с него роль");
                return;
            }
            roles.add(user.getAssignRole());
            log.info("Пользователь {}, ушел с роли {}", user.getName(), user.getAssignRole());
            user.setAssignRole(null);
            lock.notifyAll();
        }
    }

    public void addRole(String role) {
        if (role == null || role.isBlank()) {
            log.error("Роль не может быть пустой");
            return;
        }
        synchronized (lock) {
            this.roles.add(role);
            lock.notifyAll();
        }
    }
}
