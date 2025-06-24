package school.faang.bjs2_82058;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class House {
    private final List<String> availableRoles;
    private final Map<String, String> assignedRoles = new HashMap<>();

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>(roles);
    }

    public synchronized String assignRole(String userName) throws InterruptedException {
        while (availableRoles.isEmpty()) {
            log.info("{} is waiting for a role to become available...", userName);
            wait();
        }

        String role = availableRoles.remove(0);
        assignedRoles.put(userName, role);
        log.info("{} has been assigned the role: {}", userName, role);
        return role;
    }

    public synchronized void releaseRole(String userName) {
        String role = assignedRoles.remove(userName);
        if (role != null) {
            availableRoles.add(role);
            log.info("{} has released the role: {}", userName, role);
            notify();
        }
    }
}
