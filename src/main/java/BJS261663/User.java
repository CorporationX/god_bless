package BJS261663;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User {
    private String name;
    private String assignedRole;
    private House house;

    public User(String name, String assignedRole) {
        this.name = name;
        this.assignedRole = assignedRole;
    }

    public void joinHouse(House house) {
        if (house != null) {
            assignedRole = house.assignRole();
            this.house = house;
            log.info("User: " + name + " joined house: " + house);
        }
    }

    public void leaveHouse() {
        if (house != null && assignedRole != null) {
            log.info("User: " + name + " leaved house: " + house + " leave role: " + assignedRole);
            house.releaseRole(assignedRole);
            assignedRole = null;
            house = null;
        }
    }
}
