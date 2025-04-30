package school.faang.ironthrone;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final List<String> roles = new ArrayList<>();

    public House(List<String> initialRoles) {
        this.roles.addAll(initialRoles);
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted waiting for a role");
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}