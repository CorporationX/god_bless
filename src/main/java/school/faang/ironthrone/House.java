package school.faang.ironthrone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class House {
    private static final boolean AVAILABLE_ROLE = false;
    private static final boolean BUSY_ROLE = true;

    private final Object lockRole = new Object();
    private final Map<String, Boolean> roles = new HashMap<>();

    public void assignRole(String role) throws InterruptedException {
        validateRole(role);
        synchronized (lockRole) {
            while (roles.get(role) == BUSY_ROLE) {
                lockRole.wait();
            }
            roles.put(role, BUSY_ROLE);
        }
    }

    public void releaseRole(String role) {
        validateRole(role);
        synchronized (lockRole) {
            if (roles.get(role) == BUSY_ROLE) {
                roles.put(role, AVAILABLE_ROLE);
                lockRole.notifyAll();
            }
        }
    }

    public void addPackageRoles(List<String> listRoles) {
        validateListRoles(listRoles);
        roles.putAll(
                listRoles.stream().collect(Collectors.toMap(role -> role, role -> AVAILABLE_ROLE)));
    }

    private void validateRole(String role) {
        Objects.requireNonNull(role, "invalid role value");
        if (!roles.containsKey(role)) {
            throw new IllegalArgumentException("role is not found");
        }
    }

    private void validateListRoles(List<String> listRoles) {
        Objects.requireNonNull(listRoles, "invalid list roles value");
        if (listRoles.isEmpty()) {
            throw new IllegalArgumentException("list roles is empty");
        }
    }
}
