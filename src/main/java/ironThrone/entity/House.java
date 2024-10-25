package ironThrone.entity;

import ironThrone.enumeration.Role;

import java.util.HashMap;
import java.util.Map;

public class House {
    private final Map<Role, Integer> roles;

    public House() {
        roles = init();
    }

    public void addRole(Role role) throws InterruptedException {
        synchronized (roles) {
            if (roles.get(role) == 0) {
                System.out.println("Ждем освобожнение роли");
                roles.wait();
            }
            roles.put(role, roles.get(role) - 1);
        }
    }

    public void removeRole(Role role) {
        synchronized (roles) {
            roles.put(role, roles.get(role) + 1);
            System.out.println("Освободилась роль");
            roles.notifyAll();
        }
    }

    private Map<Role, Integer> init() {
        return new HashMap<>(Map.of(
                Role.LORD, 3,
                Role.KNIGHT, 4,
                Role.MAGA, 3
        ));
    }

}