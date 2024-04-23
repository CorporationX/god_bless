package faang.school.godbless.BJS2_5880;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class House {
    // Map<roleName, userName>
    private final Map<String, Integer> availableRoles = new HashMap<>();


    public void addRole(String role, User user) {
        synchronized (availableRoles) {
            int count = availableRoles.get(role);
            if (count < 0) {
                try {
                    availableRoles.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.setRole(role);
                user.setHouse(this);
                availableRoles.computeIfPresent(role, (k, v) -> v - 1);

                System.out.println(user.getName() + " add to house");
                System.out.println(availableRoles);
            }
        }
    }

    public void removeRole(String role, User user) {
        synchronized (availableRoles) {
            availableRoles.computeIfPresent(role, (k, v) -> v + 1);
            user.setHouse(null);
            user.setRole(null);
            System.out.println(user.getName() + " leave house");
            System.out.println(availableRoles);
        }
    }
}

