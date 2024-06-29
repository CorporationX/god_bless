package faang.school.godbless.multithreading_synchronization.task_6;

import java.util.HashMap;
import java.util.Map;

public class RolesProvider {
    public static Map<Role, Integer> getRoles() {
        Map<Role, Integer> roles = new HashMap<>();
        roles.put(Role.TANK, 2);
        roles.put(Role.MAGE, 1);
        roles.put(Role.ASSASSIN, 1);
        roles.put(Role.FIGHTER, 1);
        roles.put(Role.MARKSMAN, 3);
        return roles;
    }
}
