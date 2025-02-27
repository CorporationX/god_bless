package school.faang.task_61544;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class House {
    private static final Map<HouseRole, User> roles = new HashMap<>();
    private static final String ROLE_WAIT_MESSAGE = "Пользователь \"%s\" ожидает освобождения роли \"%s\"%n";
    private static final String WAIT_INTERRUPT_MESSAGE = "Ожидание потока \"%s\" прервано%n";
    private static final String ASSIGN_ROLE_MESSAGE = "Пользователь \"%s\" занял роль \"%s\"%n";
    private static final String RELEASE_ROLE_MESSAGE = "Пользователь \"%s\" освободил роль \"%s\"%n";

    private final String name;

    public void assignRole(@NonNull User user) {
        synchronized (roles) {
            String userName = user.getName();
            HouseRole role = user.getSelectedRole();
            while (roles.containsKey(role)) {
                try {
                    roles.wait();
                    System.out.printf(ROLE_WAIT_MESSAGE, userName, user.getSelectedRole());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.printf(WAIT_INTERRUPT_MESSAGE, Thread.currentThread().getName());
                    throw new RuntimeException(e);
                }
            }
            roles.put(role, user);
            System.out.printf(ASSIGN_ROLE_MESSAGE, userName, role);
        }
    }

    public void releaseRole(@NonNull HouseRole role) {
        synchronized (roles) {
            if (roles.containsKey(role)) {
                User user = roles.get(role);
                roles.remove(role);
                roles.notifyAll();
                System.out.printf(RELEASE_ROLE_MESSAGE, user.getName(), role);
            }
        }
    }
}
