package school.faang.ironThrone;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class House {
    private List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = roles;
        this.availableRoleCount = roles.size();
    }

    public String addRole() {
        String chosenRole = availableRoles.get(0);
        availableRoles.remove(0);
        availableRoleCount--;
        return chosenRole;
    }

    public void releaseRole(String role) {
        availableRoles.add(role);
        availableRoleCount++;
    }
}
