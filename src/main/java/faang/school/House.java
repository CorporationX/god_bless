package faang.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class House {
    private String name;
    private final Map<String, Integer> availableRoles;

    public boolean addUser(User user) throws InterruptedException {
        synchronized (availableRoles) {
            System.out.println(availableRoles.get(user.getRole()) + " " + Thread.currentThread().getName());

            var availableCount = availableRoles.getOrDefault(user.getRole(), -1);
            if (availableCount == 0) {
                availableRoles.wait();
            }
            if (availableCount > 0) {
                availableRoles.computeIfPresent(user.getRole(), (role, count) -> count - 1);
                System.out.println(availableRoles.get(user.getRole()));
                return true;
            }
            return false;
        }
    }

    public void removeUser(User user) {
        synchronized (availableRoles) {
            System.out.println(availableRoles.get(user.getRole()) + " before removing");
            availableRoles.computeIfPresent(user.getRole(), (role, count) -> count + 1);
            System.out.println(availableRoles.get(user.getRole()) + " after removing");
            availableRoles.notify();
        }
    }
}
