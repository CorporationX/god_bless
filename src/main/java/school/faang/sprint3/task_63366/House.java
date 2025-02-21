package school.faang.sprint3.task_63366;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Slf4j
public class House {
    private static final String logForm = "{} {} роль {}";
    private final Map<Role, User> roles = new HashMap<>();
    private final Map<Role, ReentrantLock> locks = Arrays.stream(Role.values())
            .collect(Collectors.toMap(role -> role, role -> new ReentrantLock()));

    public void assignRole(User user) {
        synchronized (locks.get(user.role())) {
            log.debug(logForm, "Пытаемся добавить", user.name(), user.role());
            roles.computeIfAbsent(user.role(), k -> null);

            while (roles.containsKey(user.role())) {
                log.debug("{} ждет своей очереди", user.name());
                try {
                    locks.get(user.role()).wait();
                } catch (InterruptedException e) {
                    log.error("Принудительно закрываем спящий поток", e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }

            roles.put(user.role(), user);
            log.debug(logForm, "Добавляем", user.name(), user.role());
        }
    }

    public void releaseRole(User user) {
        synchronized (locks.get(user.role())) {
            if (roles.containsKey(user.role()) && roles.get(user.role()).equals(user)) {
                log.debug(logForm, "Удаляем", user.name(), user.role());
                roles.remove(user.role());
                locks.get(user.role()).notify();
            }
        }

    }
}
