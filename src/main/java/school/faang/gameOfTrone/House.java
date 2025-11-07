package school.faang.gameOfTrone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class House {
    private final Map<String, String> accessRoles = new HashMap<>();

    public void assignRole(String name, String role) {
        synchronized (accessRoles) {
            try {
                while (!accessRoles.getOrDefault(role, "").isBlank()) {
                    accessRoles.wait();
                }
                accessRoles.put(role, name);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void releaseRole(String role) {
        synchronized (accessRoles) {
            accessRoles.put(role, "");
            accessRoles.notifyAll();
        }
    }
}
