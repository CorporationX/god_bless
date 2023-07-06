package the_iron_throne_at_any_cost;

import java.util.ArrayList;
import java.util.List;

public class House {
    private String name;
    private List<String> availableRoles;
    private int numberOfAvailableRoles;

    public String getName() {
        return name;
    }

    public House(String name, int numberOfAvailableRoles) {
        this.name = name;
        availableRoles = new ArrayList<>();
        this.numberOfAvailableRoles = numberOfAvailableRoles;
    }

    public void addRole(String role) {
        availableRoles.add(role);
        numberOfAvailableRoles--;
    }

    public void removeRole(String role) {
        availableRoles.remove(role);
        numberOfAvailableRoles++;
    }

    public boolean hasAvailableRole() {
        return numberOfAvailableRoles > 0;
    }

    public int getNumberOfAvailableRoles() {
        return numberOfAvailableRoles;
    }
}
