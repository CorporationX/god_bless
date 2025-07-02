package school.faang.bjs2_82052;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private final String name;
    private Role assignedRole;
    private final House house;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() {
        synchronized (house) {
            assignedRole = house.assignRole();
            System.out.printf("User: %s join to House, role: %s%n", name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (assignedRole != null) {
                System.out.printf("User: %s leave into House, role: %s%n", name, assignedRole);
                house.releaseRole(this);
                assignedRole = null;
            }
        }
    }
}
