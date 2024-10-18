package bjs2_37422;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final String name;
    private final List<String> roles;
    private int availableRoles;

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = new ArrayList<>(roles);
        this.availableRoles = roles.size();
    }

    public boolean hasAvailableRole() {
        return availableRoles > 0;
    }

    public String addRole() {
        String role = roles.remove(availableRoles - 1);
        availableRoles--;
        return role;
    }

    public void removeRole(String role) {
        availableRoles++;
        roles.add(role);
    }
}
