package bjs261468;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Getter
public class House implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(House.class);
    private static final int TASK_DURATION_MS = 1000;
    private final Object lock = new Object();
    private final Map<Role, Integer> roleToLimit = new HashMap<>();
    private final Map<Role, Integer> roleToAvailable = new HashMap<>();

    public void assignRole(Role role, int limit) {
        synchronized (lock) {
            roleToLimit.put(role, limit);
        }
    }

    public void releaseRole(Role role) {
        synchronized (lock) {
            roleToLimit.remove(role);
            roleToAvailable.remove(role);
        }
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
