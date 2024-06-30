package faang.school.godbless.theIronThroneatAnyCost;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class House {
    private List<Role> roles = new ArrayList<>();
    private List<Role> availableRoles = new ArrayList<>();
    private Map<User, Role> userRoles = new HashMap<>();

    public House(List<Role> roles, List<Role> availableRoles) {
        this.roles = roles;
        this.availableRoles = availableRoles;
    }

    public synchronized void addRole(Role role, Object lock) {
        System.out.println("addRole");
        availableRoles.remove(role);
        lock.notifyAll();

        System.out.println("Added role: " + role.getRole());
    }

    public synchronized void removeRole(Role role) {
        System.out.println("removeRole");
        availableRoles.add(role);

        System.out.println("Removed role: " + role.getRole());
    }
}
