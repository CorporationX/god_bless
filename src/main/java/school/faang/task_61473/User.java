package school.faang.task_61473;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Getter
public class User {
    private static final Logger LOG = LoggerFactory.getLogger(User.class);
    private final Random random = new Random();
    private final String name;
    private final String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void joinHouse() {
        House house = new House();
        house.assignRole(getRole());
        LOG.info("{} got the role: {}", getName(), getRole());
        try {
            Thread.sleep(random.nextInt(1000, 5000));
        } catch (InterruptedException e) {
            LOG.error("Thread was interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        house.releaseRole(getName(), getRole());
        leaveHouse();
    }

    public void leaveHouse() {
        LOG.info("{} has left the house", getName());
    }
}
