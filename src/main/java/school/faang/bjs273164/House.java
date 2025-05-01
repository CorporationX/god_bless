package school.faang.bjs273164;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class House {
    private final Object lock = new Object();
    private final List<Role> availableRoles = new ArrayList<>(Arrays.asList(Role.values()));
    private final Map<Role, User> roles = new HashMap<>();

    public Role assignRole(User user) {
        Role role;
        synchronized (lock) {
            while (availableRoles.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            role = availableRoles.remove(0);
            roles.put(role, user);
            System.out.printf("Role %s assigned to user %s (%s)\n",
                    role.name(), user.getName(), Thread.currentThread().getName());
            lock.notifyAll();
        }
        return role;
    }

    public void releaseRole(Role role) {
        synchronized (lock) {
            User user = roles.remove(role);
            availableRoles.add(role);
            System.out.printf("Role %s released to user %s (%s)\n",
                    role.name(), user.getName(), Thread.currentThread().getName());
            lock.notifyAll();
        }
    }
}

