package faang.school.godbless.IronThrone;

import lombok.Data;

import java.util.List;

@Data
public class House {
    private List<String> availableRoles;
    private int availableRolesQuantity;

    public House(List<String> availableRoles, int availableRolesQuantity) {
        this.availableRoles = availableRoles;
        this.availableRolesQuantity = availableRolesQuantity;
    }

    public synchronized void removeRole(String role) {
        this.availableRoles.remove(role);
        this.availableRolesQuantity--;
    }

    public synchronized void addRole(String role) {
        availableRoles.add(role);
        this.availableRolesQuantity++;
        notifyAll();
    }
}
