package faang.school.godbless.Iron_Throne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class House {
    private Set<String> roles;
    private int rolesAmount;
    private Map<String, User> capturedRoles;
    private final Object lock = new Object();

    public void addRole(String role) {
        synchronized (lock) {
            if (!roles.contains(role)) {
                rolesAmount++;
                roles.add(role);
                lock.notify();
            }
        }
    }

    public void removeRole(String role) {
        synchronized (lock) {
            if (roles.contains(role)) {
                rolesAmount--;
                roles.remove(role);
                lock.notify();
            }
        }
    }
}
