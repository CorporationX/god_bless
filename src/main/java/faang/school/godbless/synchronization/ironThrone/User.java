package faang.school.godbless.synchronization.ironThrone;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Getter
public class User {
    private String name;
    private String houseName = "vagabond";
    private Role role = Role.VAGABOND;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        argumentCheck(house);

        var selectedRole = house.addRole(role);

        houseName = house.getName();
        role = selectedRole;

        log.info("User " + name + " joined the " + houseName + " house with " + role + " role.");

    }

    public void leaveHouse(House house) {
        argumentCheck(house);

        if (role.equals(Role.VAGABOND)) {
            log.warn("User " + name + " is already a vagabond and can't leave any house.");

            return;
        }

        house.removeRole(role);

        log.info("User " + name + " left the " + houseName + " house and the " + role + " role.");

        houseName = "vagabond";
        role = Role.VAGABOND;

    }

    private void argumentCheck(House house) {
        if (house == null) {
            throw new IllegalArgumentException("House cannot be null!");
        }
    }
}
