package school.faang.task_61473;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class House {
    private static final Logger LOG = LoggerFactory.getLogger(House.class);
    private static final List<Role> ROLES = List.of(Role.LORD, Role.KNIGHT, Role.MAGICIAN);
    private final List<Role> rolesToChoose = new ArrayList<>(List.of(Role.LORD, Role.KNIGHT, Role.MAGICIAN));
    private final Object lock = new Object();

    public void assignRole(Role role) {
        validateRole(role);
        synchronized (lock) {
            while (!rolesToChoose.contains(role)) {
                try {
                    LOG.info("Role : {} - are taken. Waiting...", role);
                    lock.wait();
                } catch (InterruptedException e) {
                    LOG.info("Thread was interrupted while waiting");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted", e);
                }
            }

            rolesToChoose.remove(role);
        }
    }

    public void releaseRole(String name, Role role) {
        synchronized (lock) {
            LOG.info("{} has vacated role: {}. {} has left the house", name, role, name);
            rolesToChoose.add(role);
            lock.notifyAll();
        }
    }

    private void validateRole(Role role) {
        if (!ROLES.contains(role)) {
            LOG.error("There are no such roles in the list");
            throw new RuntimeException();
        }
    }
}
