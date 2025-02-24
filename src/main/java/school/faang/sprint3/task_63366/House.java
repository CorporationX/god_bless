package school.faang.sprint3.task_63366;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class House {
    private static final String logForm = "{} {} роль {}";
    private final Map<Role, User> roles = new HashMap<>();
    private final Set<Role> freeRoles = new HashSet<>();


    public House() {
        Arrays.stream(Role.values())
                .forEach(role -> {
                    roles.put(role, null);
                    freeRoles.add(role);
                });
    }

    public void assignRole(User user) {
        synchronized (freeRoles) {
            Role role = getFreeRole(user);

            roles.put(role, user);
            user.setRole(role);
            freeRoles.remove(role);

            log.debug(logForm, "Добавляем", user.getName(), role);
        }
    }

    public void releaseRole(User user) {
        synchronized (freeRoles) {
            if (user.getRole() != null) {
                log.debug(logForm, "Удаляем", user.getName(), user.getRole());

                freeRoles.add(user.getRole());
                roles.remove(user.getRole());
                user.setRole(null);
                freeRoles.notify();
            }
        }
    }

    private Role getFreeRole(User user) {
        log.debug("Ищем свободную роль для {}", user.getName());
        while (freeRoles.isEmpty()) {
            try {
                log.debug("{} ждет своей очереди", user.getName());
                freeRoles.wait();
            } catch (InterruptedException e) {
                log.error("Принудительно закрываем спящий поток", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return freeRoles.stream().findFirst().get();
    }
}
