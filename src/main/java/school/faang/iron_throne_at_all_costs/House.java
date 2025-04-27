package school.faang.iron_throne_at_all_costs;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class House {
    @Getter
    private final String name;
    private final List<String> availableRoles;
    private final ConcurrentHashMap<String, Boolean> roleAvailability;

    public House(String name, List<String> roles) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("House name cannot be null or empty");
        }
        if (roles == null) {
            throw new IllegalArgumentException("Roles list cannot be null");
        }

        this.name = name;
        this.availableRoles = new CopyOnWriteArrayList<>();
        this.roleAvailability = new ConcurrentHashMap<>();

        for (String role : roles) {
            if (role == null || role.trim().isEmpty()) {
                throw new IllegalArgumentException("Role cannot be null or empty");
            }
            if (availableRoles.contains(role)) {
                throw new IllegalArgumentException("Duplicate role: " + role);
            }
            availableRoles.add(role);
            roleAvailability.put(role, true);
        }
    }

    public synchronized void assignRole(String role, User user) throws InterruptedException {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (!availableRoles.contains(role)) {
            throw new IllegalArgumentException("Role " + role + " doesn't exist in house " + name);
        }

        while (!roleAvailability.get(role)) {
            wait();
        }

        roleAvailability.put(role, false);
        System.out.println("[" + name + "] " + user.getName() + " assigned to " + role);
        notifyAll();
    }

    public synchronized void releaseRole(String role) {
        if (!availableRoles.contains(role)) {
            throw new IllegalArgumentException("Role " + role + " doesn't exist in house " + name);
        }

        roleAvailability.put(role, true);
        System.out.println("[" + name + "] Role " + role + " is now available");
        notifyAll();
    }

    @Override
    public String toString() {
        return "House{" + name + ", roles=" + availableRoles + "}";
    }
}
