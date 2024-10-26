package school.faang.synchronizedthreads3;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<String> availableRoles;
    private int availableRoleCount;

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>(roles);
        this.availableRoleCount = roles.size();
    }

    public synchronized void addRole() {
        availableRoleCount++;
        notifyAll();
    }


    public synchronized void removeRole() {
        if (availableRoleCount > 0) {
            availableRoleCount--;
        }
    }

    public synchronized boolean hasAvailableRoles() {
        return availableRoleCount > 0;
    }

    public synchronized String assignRole() {
        if (hasAvailableRoles()) {
            return availableRoles.remove(0);
        }
        return null;
    }
}


