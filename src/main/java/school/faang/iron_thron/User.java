package school.faang.iron_thron;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Data
public class User {
    private final String name;
    private Role assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
        log.debug("Thread: {}, executing joinHouse()", Thread.currentThread().getName());
        Objects.requireNonNull(house, "house cannot be null");
        house.assignRole(this);
        log.info("Thread: {}, {} joined the house", Thread.currentThread().getName(), this);
    }

    public void leaveHouse(House house) {
        log.debug("Thread: {}, executing leaveHouse()", Thread.currentThread().getName());
        Objects.requireNonNull(house, "house cannot be null");
        house.releaseRole(this);
        log.info("Thread: {}, {} left the house", Thread.currentThread().getName(), this);
    }
}
