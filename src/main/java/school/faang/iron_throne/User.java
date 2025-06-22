package school.faang.iron_throne;

import lombok.Data;

@Data
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    void joinHouse(House house) {
        this.house = house;
        assignedRole = house.assignRole(this);
        System.out.println(name + " получил роль " + assignedRole);
    }

    void leaveHouse() {
        System.out.println(name + " покинул дом");
        house.releaseRole(assignedRole);
        assignedRole = null;
    }
}
