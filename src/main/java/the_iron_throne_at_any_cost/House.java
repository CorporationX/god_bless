package the_iron_throne_at_any_cost;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final String houseName;
    private final List<String> availableRoles;
    private int currentAvailableRoles;

    public House(String houseName, List<String> roles) {
        this.houseName = houseName;
        this.availableRoles = new ArrayList<>(roles);
        this.currentAvailableRoles = roles.size();
    }

    /**
     * Tries to add the given role to the house by removing it from the available roles.
     * If the role is available, it is removed from the available roles and the count of available roles is decremented.
     * If the role is not available, nothing is done.
     *
     * @param role The role to add to the house.
     * @return true if the role was added, false otherwise.
     */
    public boolean addRole(String role) {
        if (currentAvailableRoles > 0 && availableRoles.contains(role)) {
            availableRoles.remove(role);
            currentAvailableRoles--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a role back to the available roles of the house, potentially waking up threads waiting to join this house.
     *
     * @param role The role to add back to the available roles.
     */
    public synchronized void removeRole(String role) {
        availableRoles.add(role);
        currentAvailableRoles++;
        notifyAll();
    }
}
