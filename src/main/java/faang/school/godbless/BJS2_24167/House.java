package faang.school.godbless.BJS2_24167;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class House {

    private final String name;
    private final Map<String, Integer> roles;

    public void addRole(String roleName) {
        synchronized (roles) {
            roles.put(roleName, roles.get(roleName) - 1);
        }
    }

    public void removeRole(String roleName) {
        synchronized (roles) {
            roles.put(roleName, roles.get(roleName) + 1);
            roles.notifyAll();
        }
    }

    public boolean isAvailableRole(String roleName) {
        synchronized (roles) {
            return roles.get(roleName) > 0;
        }
    }
}
