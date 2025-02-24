package school.faang.BJS237079;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>();
        this.availableRoleCount = roles.size();
    }

    public String addRole() {
        if (!availableRoles.isEmpty()) {
            String role = availableRoles.remove(availableRoles.size() - 1);
            availableRoleCount--;
            return role;
        }
        return null;
    }

    public void removeRole(String role) {
        availableRoles.add(role);
        availableRoleCount ++;
        notifyAll();
    }

    public int getAvailableRolesInHouse() {
        return availableRoleCount;
    }
}
