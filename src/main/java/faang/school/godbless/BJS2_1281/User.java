package faang.school.godbless.BJS2_1281;

import lombok.Data;

@Data
public class User {
    private final House house;
    private String name;
    private Role role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse(Role role) {
        synchronized (house) {

            while (!house.hasAvailableRoles(role)) {
                try {
                    System.out.printf("%s is waiting for a space to %s for %s role\n", name, house.getName(), role);
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (this.role != null) {
                System.out.printf("User %s is already joined to House %s as a %s\n", name, house.getName(), role);
                return;
            }
            house.takeRole(role);
            this.role = role;
            System.out.printf("%s joined %s as %s. Available spaces for this role: %s\n", name, house.getName(), role, house.getAvailableSpacesByRole(role));
        }
    }

    public void leaveHouse() {
        if (this.role == null) {
            System.out.println("User is not joined to any House yet!");
            return;
        }
        synchronized (house) {
            house.giveRole(role);
            System.out.printf("%s left %s. Available spaces for role %s: %s\n", name, house.getName(), role, house.getAvailableSpacesByRole(role));
            this.role = null;
        }
    }
}