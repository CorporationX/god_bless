package school.faang.BJS2_37127;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final List<String> availableRoles;
    private int currentAvailableRoles;

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>(roles);
        this.currentAvailableRoles = roles.size();
    }

    public synchronized boolean addRole(String role) {
        if (currentAvailableRoles > 0 && availableRoles.contains(role)) {
            currentAvailableRoles--;
            availableRoles.remove(role);
            System.out.println("Роль " + role + " занята.");
            return true;
        }
        return false;
    }

    public synchronized void removeRole(String role) {
        currentAvailableRoles++;
        availableRoles.add(role);
        System.out.println("Роль " + role + " освобождена.");
        notifyAll();
    }

    public int getCurrentAvailableRoles() {
        return currentAvailableRoles;
    }
}
