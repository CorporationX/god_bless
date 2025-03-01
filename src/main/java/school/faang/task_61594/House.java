package school.faang.task_61594;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
public class House {
    private final List<String> roles;
    @Getter
    private final String name;

    public synchronized String assingRole() {
        if (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при ожидании роли! " + e);
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
