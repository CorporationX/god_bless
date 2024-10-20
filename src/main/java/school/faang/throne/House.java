package school.faang.throne;

import java.util.HashMap;
import java.util.Map;

public class House {
    private final Map<String, Integer> roles;
    private final Map<String, Integer> availableRoles;

    public House(Map<String, Integer> roles) {
        this.roles = roles;
        this.availableRoles = new HashMap<>(roles);
    }

    public synchronized boolean addRole(String role) {
        int count = availableRoles.getOrDefault(role, 0);
        if (count > 0) {
            availableRoles.put(role, count - 1);
            return true;
        }
        return false;
    }

    public synchronized void removeRole(String role) {
        int count = availableRoles.getOrDefault(role, 0);
        availableRoles.put(role, count + 1);
        notifyAll();
    }

    public synchronized boolean isRoleAvailable(String role) {
        return availableRoles.getOrDefault(role, 0) > 0;
    }
}
