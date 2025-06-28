package school.faang.bjs2_82052;

import java.util.List;

public class House {
    private final List<Role> availableRole;

    public House(List<Role> availableRole) {
        this.availableRole = availableRole;
    }

    public Role assignRole() {
        while (availableRole.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Role role = availableRole.get(0);
        availableRole.remove(role);
        return role;
    }

    public void releaseRole(User user) {
        Role role = user.getAssignedRole();
        availableRole.add(role);
        notifyAll();
    }
}