package faang.school.godbless.TheIronThroneAtAnyCost;

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
            roles.computeIfPresent(roleName, (key, value) -> value - 1);
        }
    }

    public void removeRole(String roleName) {
        synchronized (roles) {
            roles.computeIfPresent(roleName, (key, value) -> value + 1);
            roles.notifyAll();
        }
    }

    public boolean isAvailableRole(String roleName) {
        synchronized (roles) {
            return roles.getOrDefault(roleName, 0) > 0;
        }
    }
}
