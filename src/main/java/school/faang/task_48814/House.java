package school.faang.task_48814;

import lombok.Data;
import lombok.Setter;

import java.util.*;

@Data
public class House {
    private Map<User, Role> usersPerRoles = new HashMap<>();;
    private static final List<Role> roles = new ArrayList<>(List.of(Role.Knight, Role.Lord, Role.Wizard));
    private int availableRoles;

    public House() {
        this.availableRoles = roles.size();
    }

    public synchronized void addRole() throws InterruptedException {
        while (availableRoles == 0) {
            System.out.println("There is no available roles! Waiting...");
            wait();
        }
        availableRoles--;
    }

    public synchronized void chooseRole(User user) throws InterruptedException {
        if (user == null) {
            throw new IllegalArgumentException("User is null!");
        }
        addRole();
        Role role = roles.get(roles.size() - availableRoles - 1);
        usersPerRoles.put(user, role);
    }


    public synchronized void removeRole(User user) {
        if (!usersPerRoles.containsKey(user)) {
            throw new IllegalStateException("User does not have a role!");
        }
        usersPerRoles.remove(user);
        availableRoles++;
        notifyAll();
    }
}
