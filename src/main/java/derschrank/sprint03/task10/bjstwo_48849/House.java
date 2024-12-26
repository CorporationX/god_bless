package derschrank.sprint03.task10.bjstwo_48849;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class House implements HouseInterface {
    private final Object rolesManipulationLocker;
    private final Deque<Role> availableRoles;
    private int availableRoleCount;

    public House(List<Role> roles) {
        rolesManipulationLocker = new Object();

        availableRoles = new LinkedList<>(roles);
        availableRoleCount = availableRoles.size();
    }

    @Override
    public Role getRole(User user) {
        synchronized (rolesManipulationLocker) {
            if (availableRoleCount > 0) {
                availableRoleCount--;
                return availableRoles.poll();
            }
        }
        return null;
    }

    @Override
    public Role releaseRole(User user) {
        synchronized (rolesManipulationLocker) {
            if (user != null) {
                Role role = user.getRole();
                if (role != null) {
                    availableRoles.push(role);
                    availableRoleCount++;
                    this.notifyAll();
                }
            }
        }
        return null;
    }

    public int getAvailableRoleCount() {
        synchronized (rolesManipulationLocker) {
            return availableRoleCount;
        }
    }
}

