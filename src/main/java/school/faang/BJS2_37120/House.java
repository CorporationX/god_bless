package school.faang.BJS2_37120;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class House {
    private final List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>(roles);
        this.availableRoleCount = roles.size();
    }

    public synchronized String addRole() throws InterruptedException {
        while (availableRoleCount == 0) {
            wait();
        }
        availableRoleCount--;
        return availableRoles.get(availableRoleCount);
    }

    public synchronized void removeRole(String role) {
        if (!availableRoles.contains(role)) {
            availableRoles.add(role);
        }
        availableRoleCount++;
        notifyAll();
    }

    public synchronized int getAvailableRoleCount() {
        return availableRoleCount;
    }
}
