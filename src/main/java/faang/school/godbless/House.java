package faang.school.godbless;

import lombok.Getter;

import java.util.*;

@Getter
public class House {
    private String name;
    private Map<String, Integer> availableRoles;

    public House(String name, Map<String, Integer> roles) {
        this.name = name;
        this.availableRoles = new HashMap<>(roles);
    }

    public synchronized boolean addRole(String role) {
        if (availableRoles.containsKey(role) && availableRoles.get(role) > 0) {
            availableRoles.put(role, availableRoles.get(role) - 1);
            System.out.println("Роль " + role + " была успешно занята в доме " + name);
            return true;
        }
        return false;
    }

    public synchronized void removeRole(String role) {
        if (availableRoles.containsKey(role)) {
            availableRoles.put(role, availableRoles.get(role) + 1);
            System.out.println("Роль " + role + " была освобождена в доме " + name);
            notifyAll();
        }
    }

    public synchronized boolean isRoleAvailable(String role) {
        return availableRoles.containsKey(role) && availableRoles.get(role) > 0;
    }
}
