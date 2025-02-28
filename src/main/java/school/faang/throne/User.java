package school.faang.throne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            this.assignedRole = house.assignRole();
            this.house = house;
            System.out.printf("%s chose a role %s%n", name, assignedRole);
        }
    }

    public void leaveHouse() {
        if (house != null) {
            synchronized (house) {
                if (assignedRole != null) {
                    System.out.printf("%s leaves the house and vacates the role: %s%n", name, assignedRole);
                    house.releaseRole(assignedRole);
                    assignedRole = null;
                    house = null;
                }
            }
        }
    }
}
