package school.faang.throne;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class House {
    private final String houseName;
    private final List<Role> roles = new ArrayList<>();
    private int numRoles;

    public House(String houseName, int numRoles) {
        this.houseName = houseName;
        this.numRoles = numRoles;
    }

    public synchronized boolean addRole(Role role) {
        if (numRoles > 0) {
            roles.add(role);
            numRoles--;
            System.out.println(role + " is chosen. Roles left: " + numRoles);
            return true;
        } else {
            return false;
        }
    }

    public synchronized void removeRole(Role role) {
        roles.remove(role);
        numRoles++;
        System.out.println(role + " is now free. Roles left: " + numRoles);
        notifyAll();
    }

    enum Role {
        HOMEOWNER,
        HOUSEKEEPER,
        COOK
    }
}
