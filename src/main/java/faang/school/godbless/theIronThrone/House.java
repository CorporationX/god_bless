package faang.school.godbless.theIronThrone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private final Map<String, Integer> roles = new HashMap<>();


    public void addRole(String role, User user) {
        synchronized (roles) {
            if (roles.get(role) <= 0) {
                System.out.println(user.getName() + " is waiting until the role will be available");
                try {
                    roles.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            roles.computeIfPresent(role, (key, value) -> value - 1);
            user.setHouse(this);
            user.setRole(role);
            System.out.println(user.getName() + " joined the house of " + name + " in a role of " + role);
        }
    }

    public void removeRole(String role, User user) {
        synchronized (roles) {
            roles.computeIfPresent(role, (key, value) -> value + 1);
            user.setHouse(null);
            user.setRole(null);
            System.out.println(user.getName()+" left the house of "+ name + " and the position of " + role);
            roles.notify();
        }
    }
}
