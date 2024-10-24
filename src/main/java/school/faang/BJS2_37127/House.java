package school.faang.BJS2_37127;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final List<String> availableRoles;
    @Getter
    private int availableRoleCount;

    public House(List<String> roles) {
        availableRoles = new ArrayList<>(roles);
        availableRoleCount = roles.size();
    }

    public synchronized String addRole() {
        if (availableRoleCount > 0) {
            availableRoleCount--;
            return availableRoles.remove(0);
        }
        return null;
    }

    public synchronized void removeRole(String role) {
        availableRoles.add(role);
        availableRoleCount++;
        notifyAll();
    }

}
