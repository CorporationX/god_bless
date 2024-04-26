package TheIronThrone;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class House {
    private String name;
    private Map<Role, Integer> availableRoles;
    public static final int MAX_ROLE_SIZE = 1;

    public House(String name) {
        this.name = name;
        availableRoles = new HashMap<>();
        availableRoles.put(Role.LORD, 0);
        availableRoles.put(Role.KNIGHT, 0);
        availableRoles.put(Role.BASTARD, 0);
        availableRoles.put(Role.MAGE, 0);
    }

    public synchronized void addRole(Role role) {
        if (availableRoles.get(role) == MAX_ROLE_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        availableRoles.put(role, MAX_ROLE_SIZE);
    }

    public synchronized void removeRole(Role role) {
        availableRoles.put(role, 0);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }
}
