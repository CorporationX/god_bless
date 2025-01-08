package school.faang.bjs249123;

import lombok.Getter;
import lombok.val;

import java.util.List;

@Getter
public class House {
    private final List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = roles;
        this.availableRoleCount = availableRoles.size();
    }

    public synchronized String addRole() {
        val numLastRole = availableRoles.size() - 1;
        val role = availableRoles.remove(numLastRole);
        availableRoleCount = availableRoles.size();
        notifyAll();
        return role;
    }

    public synchronized void removeRole(String role) {
        availableRoles.add(role);
        availableRoleCount = availableRoles.size();
        notifyAll();
    }
}
