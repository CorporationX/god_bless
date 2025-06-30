package school.faang.bjs2_82052;

import java.util.List;

public class House {
    private final List<Role> availableRoles;

    public House(List<Role> availableRole) {
        this.availableRoles = availableRole;
    }

    public synchronized Role assignRole() {
        while (availableRoles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Role role = availableRoles.get(0);
        availableRoles.remove(role);
        return role;
    }

    public synchronized void releaseRole(User user) {
        Role role = user.getAssignedRole();
        availableRoles.add(role);
        notifyAll();
    }
}