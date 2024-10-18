package dima.evseenko.throne;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class House {
    private final Map<Role, User> roles = new HashMap<>();

    public void addRole(User user, Role role) {
        roles.put(role, user);
    }

    public void removeRole(User user) {
        roles.remove(user.getRole());
    }
}
