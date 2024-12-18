package school.faang.task_48814;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class House {
    private Map<User, Role> usersPerRoles = new HashMap<>();
    private static final List<Role> roles = new ArrayList<>(List.of(Role.Knight, Role.Lord, Role.Wizard));
    private int availableRoles;

    public House() {
        this.availableRoles = roles.size();
    }

    public synchronized Role addRole() throws InterruptedException {
        while (availableRoles == 0) {
            System.out.println("There is no available roles! Waiting...");
            wait();
        }
        availableRoles--;
        return roles.get(roles.size() - availableRoles - 1);
    }

    public synchronized Role chooseRole(User user) throws InterruptedException {
        if (user == null) {
            throw new IllegalArgumentException("User is null!");
        }
        Role role = addRole();
        usersPerRoles.put(user, role);
        return role;
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
