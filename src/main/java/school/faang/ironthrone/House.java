package school.faang.ironthrone;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>(roles);
        this.availableRoleCount = roles.size();
    }

    public synchronized String addRole() {
        if (availableRoleCount > 0) {
            String role = availableRoles.remove(availableRoles.size() - 1);
            availableRoleCount--;
            return role;
        }
        return null;
    }

    public synchronized void removeRole(String role) {
        availableRoles.add(role);
        availableRoleCount++;
        notifyAll();
    }

    public synchronized int getAvailableRolesInHouse() {
        return availableRoleCount;
    }
}