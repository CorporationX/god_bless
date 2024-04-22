package faang.school.godbless.iron_throne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Data
@AllArgsConstructor
@Slf4j
public class House {
    private final Object lock = new Object();
    private String name;
    private Map<HouseRole, Integer> rolesMap;

    public void addRole(HouseRole houseRole, User user) {
        synchronized (lock) {
            while (rolesMap.get(houseRole) <= 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            user.setRole(houseRole);
            user.setHouse(this);
            rolesMap.computeIfPresent(houseRole, (k, v) -> v - 1);
            log.info("User with name {}, was joined to {}, with role {}", user.getName(), name, houseRole);
        }
    }

    public void removeRole(HouseRole houseRole, User user) {
        synchronized (lock) {
            user.setHouse(null);
            user.setRole(null);
            rolesMap.computeIfPresent(houseRole, (k, v) -> v + 1);
            log.info("User with name {}, was leaved {}, with role {}", user.getName(), name, houseRole);
            lock.notify();
        }
    }
}