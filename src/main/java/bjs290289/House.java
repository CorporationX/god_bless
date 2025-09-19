package bjs290289;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class House {
    private final List<String> roles;

    public synchronized String assignRole(String userName) {
        while (roles.isEmpty()) {
            try {
                wait();
                System.out.printf("%s is waiting for free role...\n", userName);
            } catch (InterruptedException e) {
                System.err.printf("Thread was interrupted during waiting: %s\n", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        String role = roles.remove(0);
        System.err.printf("%s got the role: %s\n", userName, role);
        return role;
    }

    public synchronized void releaseRole(String role, String userName) {
        if (role != null) {
            roles.add(role);
            System.out.printf("%s leave role: %s\n", userName, role);
            notifyAll();
        }
    }
}
