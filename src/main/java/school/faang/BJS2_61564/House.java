package school.faang.BJS2_61564;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class House {
    private final List<String> roles;

    public String assignRole(User user) {
        synchronized (roles) {
            if (roles.isEmpty()) {
                try {
                    System.out.printf("%s ждет, когда появится свободная роль...\n", user.getName());
                    roles.wait();

                } catch (InterruptedException e) {
                    System.err.printf("Ошибка при ожидании роли: %s", e.getMessage());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            return roles.remove(0);
        }
    }

    public void releaseRole(String role) {
        synchronized (roles) {
            roles.add(role);
            roles.notify();
        }
    }
}
