package school.faang.irontron;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private List<String> availableRoles = new ArrayList<>();
    private int amountAvailableRoles = availableRoles.size();

    public House(List<String> availableRoles) {
        this.availableRoles = availableRoles;
    }

    public void addRole(String role) {
        availableRoles.add(role);
    }

    public void removeRole(String role) {
        availableRoles.remove(role);
    }
}
