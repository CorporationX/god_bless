package school.faang.sprint_3.task_48822;

import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class House {
    private static final int WAIT_DELAY = 1000;

    private final String name;
    private final Map<String, Boolean> availableRoles;

    public House(String name, List<String> availableRoles) {
        this.name = name;
        this.availableRoles = new HashMap<>();

        for (String availableRole : availableRoles) {
            this.availableRoles.put(availableRole, true);
        }
    }

    public synchronized String addRole() {
        while (!availableRoles.containsValue(true)) {
            try {
                wait(WAIT_DELAY);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                Thread.currentThread().interrupt();
                return null;
            }
        }
        String availableRole = getAvailableRole();
        availableRoles.put(availableRole, false);
        return availableRole;
    }

    public synchronized void removeRole(String role) {
        availableRoles.put(role, true);
        notify();
    }

    private String getAvailableRole() {
        return availableRoles.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(RuntimeException::new);
    }
}
