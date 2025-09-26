package school.faang.bjs2_90550;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            System.out.printf("User %s has joined to house %s with role %s\n",
                    name,
                    house,
                    assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                house.releaseRole(assignedRole);
                System.out.printf("User %s has left house %s and released the role %s\n", name, house, assignedRole);
                house = null;
                assignedRole = null;
            }
        }
    }
}
