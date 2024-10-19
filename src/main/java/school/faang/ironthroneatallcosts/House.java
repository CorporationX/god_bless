package school.faang.ironthroneatallcosts;

import java.util.HashMap;
import java.util.Map;

public class House {

    private Map<String, Integer> availableRoles = new HashMap<>();

    public House() {
        availableRoles.put("Lord", 1);
        availableRoles.put("Knight", 2);
        availableRoles.put("Sorcerer", 1);
    }

    public synchronized boolean addRole(String role) {
        int available = availableRoles.getOrDefault(role, 0);
        if (available > 0) {
            availableRoles.put(role, available - 1);
            return true;
        }
        return false;
    }

    public synchronized void removeRole(String role) {
        availableRoles.put(role, availableRoles.getOrDefault(role, 0) + 1);
        notifyAll();
    }

    public synchronized boolean isRoleAvailable(String role) {
        return availableRoles.getOrDefault(role, 0) > 0;
    }
}