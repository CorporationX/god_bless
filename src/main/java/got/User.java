package got;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class User implements Runnable {
    private final String name;
    private final House house;
    private String assignedRole;

    public User(String name, House house) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        if (house == null) {
            throw new IllegalArgumentException("House must not be null");
        }
        this.name = name;
        this.house = house;
        this.assignedRole = null;
    }

    public void joinHouse() {
        try {
            log.info("{} is trying to join the house...", name);
            assignedRole = house.assignRole();
            log.info("{} joined the house as {}", name, assignedRole);
        } catch (InterruptedException e) {
            log.error("{} was interrupted while waiting for a role", name, e);
            Thread.currentThread().interrupt();
        }
    }

    public void leaveHouse() {
        if (assignedRole != null) {
            log.info("{} is leaving the house, releasing role {}", name, assignedRole);
            house.releaseRole(assignedRole);
            assignedRole = null;
        } else {
            log.warn("{} is not in the house", name);
        }
    }

    @Override
    public void run() {
        joinHouse();
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            log.error("{} was interrupted while in the house", name, e);
            Thread.currentThread().interrupt();
        }
        leaveHouse();
    }
}
