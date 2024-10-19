package bjs2_35743;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class House {
    private List<Role> availableRoles;
    private int availableRolesAmount;

    public synchronized void addRole(Role role) {
        availableRoles.add(role);
        availableRolesAmount++;
        notify();
    }

    public synchronized void removeRole(Role role) {
        if (!availableRoles.contains(role)) {
            System.out.println("No role to remove");
            return;
        }
        availableRoles.remove(role);
        availableRolesAmount--;
    }

    public boolean addUserWithRole(Role role) {
        return availableRolesAmount != 0;
    }
}
