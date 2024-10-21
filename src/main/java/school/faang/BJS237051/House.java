package school.faang.BJS237051;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class House {
    private List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>(roles);
        this.availableRoleCount = roles.size();
    }

    public String addRole() {
        Random random = new Random();
        String role = availableRoles.get(random.nextInt(availableRoles.size()));
        availableRoles.remove(role);
        availableRoleCount--;
        return role;
    }

    public void removeRole(String role) {
        availableRoles.add(role);
        availableRoleCount++;
        notifyAll();
    }
}