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

    public synchronized void addRole(Role role) {
        availableRoles.add(role);
        currentNumOfAvailableRoles++;
    }

    public synchronized void removeRole(Role role) {
        availableRoles.remove(role);
        currentNumOfAvailableRoles--;
    }
}
