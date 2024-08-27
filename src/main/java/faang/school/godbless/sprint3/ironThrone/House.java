package faang.school.godbless.sprint3.ironThrone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
@Getter
public class House {
    private final int houseId;
    private final String name;
    private Map<Role, Integer> freeRoles;
    private int availableRoles;

    public synchronized Role addRole() {
        Role role = getFreeRole();
        if (freeRoles.containsKey(role)) {
            if (freeRoles.get(role) == 1) {
                freeRoles.remove(role);
            } else {
                freeRoles.put(role, freeRoles.get(role) - 1);
            }
            availableRoles--;
        }
        return role;
    }

    public synchronized void removeRole(Role role) {
        freeRoles.put(role, freeRoles.getOrDefault(role, 0) + 1);
        availableRoles++;
        this.notifyAll();
    }

    private Role getFreeRole() {
        List<Role> roles = freeRoles.keySet().stream().toList();
        return roles.get(new Random().nextInt(roles.size()));
    }
}
