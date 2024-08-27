package faang.school.godbless.IronThrone;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

@Setter
@Slf4j
public class House {
    private final Queue<String> roles = new LinkedList<>(List.of("№1", "№2", "№3"));
    private Integer availableRoles;
    private final Object availableLock = new Object();


    public void addRole(User user) {
        String role;
        try {
            synchronized (roles) {
                while (roles.isEmpty()) {
                    roles.wait();
                }
                role = roles.poll();
            }
            user.setRole(role);
            log.info("ADD : {}, Role: {}", user.getName(), user.getRole());
            synchronized (availableLock) {
                while (availableRoles <= 0) {
                    availableLock.wait();
                }
                availableRoles--;
                log.info("                                  availableRoles   {}", availableRoles);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
            user.setRole(null);
        }
    }

    public void removeRole(User user) {
        String role = user.getRole();
        user.setRole(null);
        log.info("Remove : {}, Role: {} (old - >{})", user.getName(), user.getRole(), role);

        synchronized (roles) {
            roles.add(role);
            roles.notifyAll();
        }
        synchronized (availableLock) {
            availableRoles++;
            log.info("                                  availableRoles   {}", availableRoles);
            availableLock.notifyAll();
        }
    }

}
