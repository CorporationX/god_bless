package faang.school.godbless.the_iron_throne;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class House {

    private String name;
    private final Map<String, Integer> roles = new HashMap<>();

    public void addRole(String role, User user) {
        synchronized (roles) {
            if (roles.get(role) <= 0) {
                System.out.println("Wait "+ user.getName()+" until the role is released");
                try {
                    roles.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            roles.computeIfPresent(role, (key, value) -> value - 1);
            user.setHouse(this);
            user.setRole(role);
            System.out.println("User " + user.getName() + " got into " + name + " for a role " + role);
        }
    }

    public void removeRole(String role, User user) {
        synchronized (roles) {
            roles.computeIfPresent(role, (key, value) -> value + 1);
            user.setHouse(null);
            user.setRole(null);
            System.out.println("Left "+ user.getName()+" and position " + role);
            roles.notify();
        }
    }
}
