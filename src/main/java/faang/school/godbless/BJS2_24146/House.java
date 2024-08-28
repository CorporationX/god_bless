package faang.school.godbless.BJS2_24146;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class House {
    private String name;
    private List<String> availableRoles = new ArrayList<>();
    private List<User> userInHouse = new ArrayList<>();
    private Integer numRoles;

    public House(String name, int numRoles) {
        this.name = name;
        this.numRoles = numRoles;
    }

    public void addRole(String role) {
        synchronized (this) {
            availableRoles.remove(role);
            numRoles--;
        }
    }

    public void removeRole(String role) {
        synchronized (this) {
            availableRoles.add(role);
            numRoles++;
            this.notifyAll();
        }
    }

    public void addUserInHouse(User user) {
        userInHouse.add(user);
    }

    public void addRoleInAvailableRoles(String role) {
        availableRoles.add(role);
    }
}
