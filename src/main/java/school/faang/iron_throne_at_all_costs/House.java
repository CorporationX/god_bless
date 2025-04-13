package school.faang.iron_throne_at_all_costs;

import java.util.HashSet;
import java.util.Set;

public class House {
    private String name;
    private final Set<String> availableRoles = new HashSet<>();
    private final Object lockObject = new Object();

    public String getName() {
        return name;
    }

    public House(String name) {
        this.name = name;
    }

    public void addRole(String role) {
        availableRoles.add(role);
    }

    public String assignRole(String name) {
        synchronized (lockObject) {
            while (availableRoles.isEmpty()) {
                try {
                    lockObject.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Available roles for your chose: " + availableRoles);
            String role = availableRoles.stream().findFirst().orElseThrow(() ->
                    new IllegalArgumentException("availableRoles contains null!"));
            System.out.println("User " + name + " has chosen the role " + role);
            availableRoles.remove(role);
            return role;
        }
    }

    public void releaseRole(String role) {
        synchronized (lockObject) {
            availableRoles.add(role);
            lockObject.notifyAll();
        }
    }
}
