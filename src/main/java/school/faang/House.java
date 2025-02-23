package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class House {
    private static final Logger logger = LoggerFactory.getLogger(House.class);
    private final List<String> roles;
    private final Object lock = new Object();

    public House(List<String> roles) {
        this.roles = roles;
    }

    public String assignRole() {
        synchronized (lock) {
            if (!roles.isEmpty()) {
                return roles.remove(roles.size() - 1);
            }
        }
        synchronized (lock) {
            while (roles.isEmpty()) {
                try {
                    lock.wait(TimeUnit.SECONDS.toMillis(30));
                } catch (InterruptedException e) {
                    logger.error("Wait was interrupted.");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            return roles.remove(roles.size() - 1);
        }
    }

    public void releaseRole(String role) {
        synchronized (lock) {
            roles.add(role);
            lock.notify();
        }
    }
}
