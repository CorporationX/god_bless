package school.faang.sprint3.task_61473;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Getter
public class User {
    private static final Logger LOG = LoggerFactory.getLogger(User.class);
    private final Random random = new Random();
    private final String name;
    private final Role role;
    private final House house;

    public User(String name, Role role, House house) {
        this.name = name;
        this.role = role;
        this.house = house;
    }

    public synchronized void joinHouse() {
        house.assignRole(getRole());
        LOG.info("{} got the role: {}", getName(), getRole());
        try {
            Thread.sleep(random.nextInt(5000, 7000));
        } catch (InterruptedException e) {
            LOG.error("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void leaveHouse() {
        house.releaseRole(getName(), getRole());
    }
}
