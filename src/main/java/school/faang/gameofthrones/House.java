package school.faang.gameofthrones;

import lombok.Data;

import java.util.List;

@Data
public class House {
    private String name;
    private List<Role> availableRoles;
    private int currentNumOfAvailableRoles;

    public House(String name, List<Role> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        this.currentNumOfAvailableRoles = availableRoles.size();
    }

    public void addRole(Role role) {
        synchronized (this) {
            availableRoles.add(role);
            currentNumOfAvailableRoles++;
        }
    }

    public void removeRole(Role role) {
        synchronized (this) {
            availableRoles.remove(role);
            currentNumOfAvailableRoles--;
        }
    }
}
