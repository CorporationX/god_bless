package bjs2_73222_The_Iron_Throne_at_any_cost;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class User {
    private String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House newHouse) {
        synchronized (house) {
            assignedRole = house.assignRole();
            house = newHouse;
            log.info("{} joined house", name);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (assignedRole != null && house != null) {
                house.releaseRole(assignedRole);
                log.info("{} left house {} and releases the role {}", name, house, assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
