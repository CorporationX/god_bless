package gameofthrones;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class House {
    private List<String> roles;

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("an Error occurred while waiting for a role: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}
