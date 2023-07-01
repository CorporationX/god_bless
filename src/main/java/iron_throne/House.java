package iron_throne;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private final String name;
    private final List<String> roles;
    private int availableRoles;

    public House(String name) {
        this.name = name;
        this.roles = new ArrayList<>();
        this.availableRoles = 0;
    }

    public synchronized void addRole(String role) {
        roles.add(role);
        availableRoles++;
        System.out.println("Added role '" + role + "' to house " + name);
        notifyAll();
    }

    public synchronized void removeRole(String role) {
        roles.remove(role);
        availableRoles--;
        System.out.println("Removed role '" + role + "' from house " + name);
        notifyAll();
    }

    public synchronized boolean hasAvailableRoles() {
        return availableRoles > 0;
    }

    public synchronized String selectRole() {
        Random random = new Random();
        int index = random.nextInt(availableRoles);
        String role = roles.get(index);
        removeRole(role);
        return role;
    }
}