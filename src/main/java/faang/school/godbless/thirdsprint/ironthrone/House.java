package faang.school.godbless.thirdsprint.ironthrone;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class House {
    private final String name;
    public final Map<Role, Integer> rolesMap;

    public House(String name) {
        this.name = name;
        this.rolesMap = new HashMap<>();
    }

    public synchronized void addRole(Role role) {
        rolesMap.put(role, rolesMap.get(role) - 1);
    }

    public synchronized void removeRole(Role role) {
        rolesMap.put(role, rolesMap.get(role) + 1);
        notifyAll();
    }

    public synchronized boolean isRoleAvailable(Role role) {
        return rolesMap.getOrDefault(role, 0) > 0;
    }

    public synchronized void addAvailableRoles(Role role, int amount) {
        rolesMap.put(role, amount);
    }
}
