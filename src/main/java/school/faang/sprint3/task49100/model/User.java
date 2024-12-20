package school.faang.sprint3.task49100.model;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class User {

    private final String name;
    private Role role;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        if (this.house == null || !this.house.equals(house)) {
            for (Role role : Role.values()) {
                Role addedRole = house.addRole(role);
                if (addedRole != null) {
                    this.role = addedRole;
                    this.house = house;
                    log.info("User " + this.name
                            + " joined to house of " + this.house
                            + " with a role of " + this.role);
                    return;
                }
            }
        }
    }

    public void leaveHouse() {
        if (house != null) {
            house.removeRole(this.role);
            log.info("User " + this.name
                    + " leave house of " + this.house
                    + ". Role " + this.role + " is vacant now.");
            role = null;
            house = null;
        }

    }
}
