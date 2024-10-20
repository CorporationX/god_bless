package school.faangSprint3.t10;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private List<String> availableRoles;
    private int availableRoleCount;
    private String name;

    public House(String name, List<String> roles) {
        this.name = name;
        this.availableRoles = new ArrayList<>(roles);
        this.availableRoleCount = roles.size();
    }

    public synchronized String addRole() {
        if (availableRoleCount > 0) {
            String role = availableRoles.get(availableRoleCount - 1);
            availableRoleCount--;
            return role;
        }
        return null;
    }

    public synchronized void removeRole(String role) {
        if (role != null) {
            availableRoles.add(role);
            availableRoleCount++;
            notifyAll();
        }
    }

    public synchronized int getAvailableRoleCount() {
        return availableRoleCount;
    }
}