package bjs2_35743;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class House {
    private Map<String, Integer> availableRoles;
    private int availableRolesAmount;

    public synchronized void addRole(String role) {
        availableRoles.put(role, availableRoles.getOrDefault(role, 0) + 1);
        availableRolesAmount++;
        notify();
    }

    public synchronized void removeRole(String role) {
        if (!availableRoles.containsKey(role) || availableRoles.get(role) == 0) {
            System.out.println("No role to remove");
            return;
        }
        availableRoles.put(role, availableRoles.get(role) - 1);
        availableRolesAmount--;
    }

}
