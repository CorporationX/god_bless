package ironthrone;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
class User extends Thread {
    private static final String MSG_JOINED_HOUSE = "[{}] joined '{}' as '{}'";
    private static final String MSG_LEFT_HOUSE = "[{}] left '{}' and released '{}'";
    private static final String MSG_SLEEP_INTERRUPTED = "[{}] Error while sleeping!";
    private static final String MSG_EXCEPTION_ERROR = "Error while sleeping!";

    private static final int MIN_SLEEP_TIME = 1000;
    private static final int MAX_SLEEP_TIME = 5000;

    private final String name;
    private final House house;
    private String assignedRole;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public void run() {
        joinHouse();
        sleepRandomTime();
        leaveHouse();
    }

    public void joinHouse() {
        assignedRole = house.assignRole();
        log.info(MSG_JOINED_HOUSE, name, house.getName(), assignedRole);
    }

    public void leaveHouse() {
        Optional.ofNullable(assignedRole).ifPresent(role -> {
            house.releaseRole(role);
            log.info(MSG_LEFT_HOUSE, name, house.getName(), role);
            assignedRole = null;
        });
    }

    private void sleepRandomTime() {
        try {
            Thread.sleep((long) (Math.random() * (MAX_SLEEP_TIME - MIN_SLEEP_TIME) + MIN_SLEEP_TIME));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(MSG_SLEEP_INTERRUPTED, name, e);
            throw new RuntimeException(MSG_EXCEPTION_ERROR, e);
        }
    }
}
