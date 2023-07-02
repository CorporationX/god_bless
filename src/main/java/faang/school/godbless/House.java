package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<String> availableRoles;
    private int availableRoleCount;

    public House() {
        availableRoles = new ArrayList<>();
        availableRoleCount = 0;
    }

    public synchronized void addRole(String role) {
        availableRoles.add(role);
        availableRoleCount++;
        notifyAll();
    }

    public synchronized void removeRole(String role) {
        availableRoles.remove(role);
        availableRoleCount--;
        notifyAll();
    }
    public synchronized boolean hasAvailableRoles() {
        return availableRoleCount > 0;
    }

    public synchronized String getAvailableRole() {
        if (availableRoleCount > 0) {
            return availableRoles.get(0);
        }
        return null;
    }
}
