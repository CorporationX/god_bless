package school.faang.sprint_3.task_48988;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class User {
    private final String name;
    private Roles userRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (Objects.requireNonNull(house)) {
            while (house.getCurrentNumberOfAvailableRoles() == 0) {
                log.info("{} waiting for a role to become available.", name);
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    log.error("Error message: ", e);
                }
            }
        }
        this.userRole = house.addRole();
        log.info("{} chose the role: {}", name, userRole);
    }

    public void leaveHouse(House house) {
        synchronized (Objects.requireNonNull(house)) {
            log.info("{} leaves the house and vacates the role: {}", name, userRole);
            house.removeRole();
            this.userRole = null;
            house.notifyAll();
        }
    }
}
