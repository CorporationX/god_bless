package school.faang.bjs273221;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<String> availableRoles = new ArrayList<>();

    public void assignRole(User user) throws InterruptedException {
        synchronized (availableRoles) {
            if (user.getAssignedRole() != null) {
                releaseRole(user);
            }

            while (availableRoles.isEmpty()) {
                log.info("Role currently unavailable. {} waiting...", user.getName());
                availableRoles.wait();
            }
            String role = availableRoles.remove(0);
            user.setAssignedRole(role);
            availableRoles.remove(role);
            log.info("Role \"{}\" assigned: {}", role, user.getName());
        }
    }

    public void releaseRole(User user) {
        synchronized (availableRoles) {
            String assignedRole = user.getAssignedRole();
            if (assignedRole == null) {
                log.error("{} have no role yet.", user.getName());
                return;
            }
            availableRoles.add(assignedRole);
            user.setAssignedRole(null);
            log.info("Role \"{}\" released: {}", assignedRole, user.getName());
            availableRoles.notify();
        }
    }

    public void addRole(String role) {
        availableRoles.add(role);
        log.info("Role added to house \"{}\"", role);
    }
}
