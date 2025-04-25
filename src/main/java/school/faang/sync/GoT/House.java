
package school.faang.sync.GoT;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class House {
    private final Map<String, Boolean> assignedRoles = new HashMap<>();
    private final Object lock = new Object();

    public House(HouseRoles[] roles) {
        for (HouseRoles role : roles) {
            assignedRoles.put(role.name(), false);
        }
    }

    public void assignRole(String role) throws InterruptedException {
        synchronized (lock) {
            while (assignedRoles.get(role)) {
                log.info("{} in this house currently occupied", role);
                lock.wait();
            }
            assignedRoles.put(role, true);
            log.info("{} was assigned to house", role);
        }

    }

    public void releaseRole(HouseRoles role) {
        synchronized (lock) {
            assignedRoles.put(role.name(), false);
            log.info("{} in this house was released just now", role.name());
            lock.notify();
        }
    }
}
