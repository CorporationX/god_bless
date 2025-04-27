package school.faang.iron_throne_at_all_costs;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private String assignedRole;
    private House currentHouse;

    public User(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        this.name = name;
    }

    public void joinHouse(House house, String desiredRole) throws InterruptedException {
        if (house == null || desiredRole == null) {
            throw new IllegalArgumentException("House and role cannot be null");
        }
        if (currentHouse != null) {
            throw new IllegalStateException(name + " is already in a house");
        }

        System.out.println(name + " attempting to acquire role " + desiredRole);
        house.assignRole(desiredRole, this);
        this.assignedRole = desiredRole;
        this.currentHouse = house;
        System.out.println(name + " successfully joined house as " + desiredRole);
    }

    public void leaveHouse() {
        if (currentHouse == null) {
            throw new IllegalStateException(name + " is not in any house");
        }

        currentHouse.releaseRole(assignedRole);
        System.out.println(name + " left the house and released role " + assignedRole);
        this.assignedRole = null;
        this.currentHouse = null;
    }
}
