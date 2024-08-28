package faang.school.godbless.thirdsprint.ironthrone;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class House {
    private final Object lock = new Object();
    private final String name;
    public final Map<Role, Integer> rolesMap;

    public House(String name) {
        this.name = name;
        this.rolesMap = new HashMap<>();
    }

    public void addRole(Role role) {
        synchronized (lock) {
            rolesMap.put(role, rolesMap.get(role) - 1);
        }
    }

    public void removeRole(Role role) {
        synchronized (lock) {
            rolesMap.put(role, rolesMap.get(role) + 1);
            lock.notifyAll();
        }
    }

    public boolean isRoleAvailable(Role role) {
        synchronized (lock) {
            return rolesMap.getOrDefault(role, 0) > 0;
        }
    }

    public void addAvailableRoles(Role role, int amount) {
        synchronized (lock) {
            rolesMap.put(role, amount);
        }
    }
}
