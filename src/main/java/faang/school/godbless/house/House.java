package faang.school.godbless.house;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class House {
    private final String houseName;
    private final List<String> availableRoles;
    private final Map<String, Integer> roles;

    public House(String houseName, List<String> availableRoles) {
        this.houseName = houseName;
        this.availableRoles = availableRoles;
        this.roles = new HashMap<>();
        for (String role : availableRoles) {
            this.roles.put(role, 0);
        }
    }

    public synchronized void addRole(String role, int count) {
        if (availableRoles.contains(role)) {
            availableRoles.add(role);
        }
        roles.put(role, roles.getOrDefault(role, 0) + count);
        notifyAll();
    }

    public synchronized void removeRole(String role) {
        if (roles.containsKey(role) && roles.get(role) > 0) {
            roles.put(role, roles.get(role) - 1);
            notifyAll();
        }
    }

    public synchronized boolean isRoleAvailable(String role) {
        return roles.getOrDefault(role, 0) > 0;
    }
}

