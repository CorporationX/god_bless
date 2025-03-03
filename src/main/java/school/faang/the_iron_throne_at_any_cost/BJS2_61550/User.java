package school.faang.the_iron_throne_at_any_cost.BJS2_61550;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    private final String name;
    private String assignedRole;

    public User(@NonNull String name) {
        this.name = name;
    }

    public void joinHouse(@NonNull House house) throws InterruptedException {
        synchronized (house) {
            while (house.getRoles().isEmpty()) {
                LOGGER.info("{} в ожидании роли...", name);

                try {
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();

                    LOGGER.warn("{} был прерван во время ожидания роли", name);
                    return;
                }
            }
            assignedRole = house.assignRole();

            LOGGER.info("{} берёт роль {}", name, assignedRole);
        }
    }

    public void leaveHouse(@NonNull House house) throws InterruptedException {
        synchronized (house) {
            house.releaseRole(assignedRole);
            assignedRole = null;

            LOGGER.info("{} возвращает роль", name);
        }
    }
}
