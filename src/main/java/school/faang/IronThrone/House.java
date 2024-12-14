package school.faang.IronThrone;

import java.util.List;
import java.util.concurrent.Semaphore;

public class House {

    private final List<String> availableRoles;
    private final Semaphore rolesCounter;

    public House(List<String> availableRoles) {
        this.availableRoles = availableRoles;
        rolesCounter = new Semaphore(availableRoles.size());
    }

    public String getRole() {
        try {
            rolesCounter.acquire();
            return availableRoles.remove(availableRoles.size() - 1);
        } catch (InterruptedException e) {
            rolesCounter.release();
            throw new IllegalStateException("Failed to acquire roles", e);
        }
    }

    public void removeRole(String role) {
        availableRoles.add(role);
        rolesCounter.release();
    }
}
