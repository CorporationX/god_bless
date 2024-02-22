package faang.school.godbless.ironthrone;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class House {

    private String name;
    private Map<String, Long> roles = new HashMap<>();
    private int freeRolesCnt;

    public House(String name) {
        this.name = name;
    }

    public synchronized void addRole(String role) {
        roleValidate(role);
        roles.put(role, roles.get(role) + 1);
        freeRolesCnt--;
    }

    public synchronized void removeRole(String role) {
        roleValidate(role);
        if (roles.get(role) != null && roles.get(role) == 1) {
            roles.put(role, 0L);
        } else {
            roles.put(role, roles.get(role) - 1);
        }
        freeRolesCnt++;
    }

    public synchronized void addNewRole(String role) {
        stringValidate(role);
        roles.putIfAbsent(role, 0L);
        freeRolesCnt++;
    }

    private void roleValidate(String role) {
        stringValidate(role);
        if (!roles.containsKey(role)) {
            throw new IllegalArgumentException(String.format("House %s does not contains role %s", getName(), role));
        }
    }

    private void stringValidate(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Role can't be null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("Role can't be empty");
        }
    }
}
