package school.faang.ironthrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private static final String DEFAULT_ROLE = "None";
    private static final int MAX_TIME_EXECUTION = 500;
    private static final int MIN_TIME_EXECUTION = 300;

    private final String name;

    private String role = DEFAULT_ROLE;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) throws InterruptedException {
        imitateDelay();
        house.assignRole(role);
        Thread.sleep(1);
        log.info("User {} joined house with role {}", name, role);
        this.role = role;
    }

    public void leaveHouse(House house) throws InterruptedException {
        imitateDelay();
        house.releaseRole(getRole());
        log.info("User {} left house", name);
        this.role = DEFAULT_ROLE;
    }

    private void imitateDelay() throws InterruptedException {
        Thread.sleep((long) (Math.random() * MAX_TIME_EXECUTION + MIN_TIME_EXECUTION));
    }
}
