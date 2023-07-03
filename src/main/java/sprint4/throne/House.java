package sprint4.throne;

import lombok.Data;

import java.util.Map;

@Data
public class House {
    private final Map<String, Integer> roles;

    public void addRole(String role, int currentCount) {
        roles.put(role, currentCount - 1);
    }

    public void removeRole(String role) {
        roles.put(role, roles.get(role) + 1);
        notify();
    }
}
