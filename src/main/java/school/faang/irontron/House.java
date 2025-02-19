package school.faang.irontron;


import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
public class House {
    private final String name;
    private final Set<Role> roles;
    private final Map<User, Role> assignedRoles;

    public House(String name, Set<Role> roles) {
        this.name = name;
        this.roles = new HashSet<>(roles);
        assignedRoles = new ConcurrentHashMap<>();
    }

    public synchronized Boolean assignRole(@NonNull User user, @NonNull Role role) throws InterruptedException {
        if (!checkRoles(role)) {
            return false;
        }
        if (assignedRoles.containsKey(user)) {
            log.info("{} уже занимает другую роль", user.getName());
            return false;
        }
        if (assignedRoles.containsValue(role)) {
            log.info("{} ждет освобождения роли {} в доме {}", user.getName(), role, name);
            wait();
        }
        assignedRoles.put(user, role);
        user.setRole(role);
        user.setHouse(this);
        return true;
    }

    public synchronized Boolean releaseRole(@NonNull Role role) {
        if (!checkRoles(role)) {
            return false;
        }
        if (!assignedRoles.containsValue(role)) {
            log.info("Данная роль {} не занята", role);
            return false;
        }
        if (assignedRoles.entrySet().removeIf(entry -> entry.getValue().equals(role))) {
            notifyAll();
            return true;
        }
        return false;
    }

    private Boolean checkRoles(Role role) {
        if (roles.contains(role)) {
            return true;
        }
        log.info("Данной роли {} нет в доме {}", role, name);
        return false;
    }
}
