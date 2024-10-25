package school.faang_sprint_3.iron_throne_in_any_cost;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@ToString
public class User {
    private final String name;
    private House house;
    private Role userRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            while (house.getCurrentAvailableRoles() == 0) {
                try {
                    log.info("{}, Waiting for any roles to become available", name);
                    house.wait();
                } catch (InterruptedException e) {
                    log.error("An error occurred while waiting for role:{}", userRole, e);
                    throw new IllegalStateException(e);
                }
            }
            this.house = house;
            house.addRole().ifPresentOrElse(role -> this.userRole = role,
                    () -> log.error("{}, No available role found", userRole));
            userRole.setAvailable(false);
            house.notifyAll();
            log.info("User:{}, Role:{} joined", name, userRole);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            userRole.setAvailable(true);
            house.removeRole(userRole);
            house.notifyAll();
            log.info("User:{}, leaving house:{}", name, house);
        }
    }
}
