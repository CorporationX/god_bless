package ironthrone;

import lombok.Data;

import java.util.List;

@Data
public class House {
    private List<String> roles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.roles = roles;
        this.availableRoleCount = roles.size();
    }

    public void addRole() {
        availableRoleCount--;
    }

    public void removeRole() {
        availableRoleCount++;
    }
}
