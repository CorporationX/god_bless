package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class House {
    private static final Logger logger = LoggerFactory.getLogger(House.class);
    private final List<String> roles = new ArrayList<>();

    public synchronized String assignRole() {
        while(roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error("Wait was interrupted.");
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void addRole(String role) {
        roles.add(role);
        logger.info("{} added.", role);
        notifyAll();
    }
}
