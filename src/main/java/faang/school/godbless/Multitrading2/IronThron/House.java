package faang.school.godbless.Multitrading2.IronThron;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private String name;
    public List<String> roles = new ArrayList<>();
    private int availableRoles;

    public House(String name, List<String> roles, int availableRoles) {
        this.name = name;
        this.roles.addAll(roles);
        this.availableRoles = availableRoles;
    }
    public void addRole(String role) {
        synchronized (this) {
            roles.add(role);
            availableRoles--;
            System.out.println("Roles add, available: " + availableRoles);
        }
    }

    public void removeRole(String role) {
        synchronized (this) {
            roles.remove(role);
            availableRoles++;
            System.out.println("Roles remove, available: " + availableRoles);
        }
    }
}
