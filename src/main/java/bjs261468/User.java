package bjs261468;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    private static final int TASK_DURATION_MS = 1000;
    private static final int WAIT_DURATION_MS = 2000;
    private final Object lock = new Object();
    private final Map<User, House> userToHouse = new HashMap<>();
    private String name;
    private Role assignedRole;

    public void joinHouse(House house, Role role) throws InterruptedException {
        synchronized (lock) {
            if (Objects.nonNull(house) && Objects.nonNull(role)) {
                Integer numberAvailableRoles = house.getRoleToAvailable().getOrDefault(role, 0);
                Integer numberLimitRoles = house.getRoleToLimit().getOrDefault(role, 0);
                if (numberAvailableRoles > numberLimitRoles) {
                    LOGGER.info("Thread {}, {} waiting to change role to {}",
                            Thread.currentThread().getName(), this, role);
                    lock.wait(WAIT_DURATION_MS);
                } else {
                    userToHouse.put(this, house);
                    this.setAssignedRole(role);
                    house.getRoleToAvailable().putIfAbsent(role, 1);
                    house.getRoleToAvailable().computeIfPresent(role,
                            (roleKey, numberAvailable) -> house.getRoleToAvailable().get(roleKey) + 1);
                    LOGGER.info("Thread {}, {} has got role {}",
                            Thread.currentThread().getName(), this, role);
                }
            }
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            LOGGER.info("Thread {}, {} out of role {}",
                    Thread.currentThread().getName(), this, this.getAssignedRole());
            userToHouse.remove(this);
            this.setAssignedRole(Role.DEFAULT_WITHOUT_ROLE);
            House house = new House();
            house.getRoleToAvailable().compute(this.getAssignedRole(),
                    (roleKey, numberAvailable) -> house.getRoleToAvailable().get(this.getAssignedRole()) - 1);
            lock.notify();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", assignedRole=" + assignedRole +
                '}';
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TASK_DURATION_MS);
        } catch (InterruptedException e) {
            LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                    Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}
