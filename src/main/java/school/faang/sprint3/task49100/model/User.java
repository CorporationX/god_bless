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
                    log.info("User {} joined to house of {} with a role of {}",
                            this.name, this.house.getName(), this.role.name());
                    return;
                }
            }
        }
    }

    public void leaveHouse() {
        if (house != null) {
            house.removeRole(this.role);
            log.info("User {} leave house of {}. Role {}} is vacant now.",
                    this.name, this.house.getName(), this.role.name());
            role = null;
            house = null;
        }
    }
}
