package school.faang.iron_tron;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@Setter
public class User {
    private String name = "Игрок";
    private static final AtomicInteger userCount = new AtomicInteger(0);
    private String assignedRole;
    private final long timeInTheHouse = 5L;

    public User() {
        this.name = getName() + userCount.incrementAndGet();

    }

    public void joinHouse(House house, String role) {
        house.assignRole(this, role);
        log.info("{} joined house as {}", getName(), getAssignedRole());
        try {
            Thread.sleep(timeInTheHouse);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        leaveHouse(house);
    }

    public void leaveHouse(House house) {
        house.releaseRole(this);
        log.info("{}:{} leaved house", getName(), getAssignedRole());
    }
}
