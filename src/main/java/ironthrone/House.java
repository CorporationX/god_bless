package ironthrone;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class House {
    @Getter
    private final Object lock;
    @Getter
    private final String name;
    private final Map<HouseRole, Integer> availableRoleSlots;

    public void addRole(HouseRole role) {
        synchronized (lock) {
            if (availableRoleSlots.get(role) - 1 < 0) {
                throw new IllegalArgumentException("Count of available role can't be less than 0");
            }
            availableRoleSlots.put(role, availableRoleSlots.get(role) - 1);
        }
    }

    public void removeRole(HouseRole role) {
        synchronized (lock) {
            availableRoleSlots.merge(role, 1, Integer::sum);
            this.lock.notifyAll();
        }
    }

    public boolean isAnyRoleAvailable() {
        synchronized (lock) {
            return availableRoleSlots.values().stream()
                    .anyMatch(count -> count > 0);
        }
    }

    public List<HouseRole> getAvailableRoles() {
        synchronized (lock) {
            return availableRoleSlots.keySet().stream()
                    .filter(r -> availableRoleSlots.get(r) > 0)
                    .toList();
        }
    }

    public void printRolesSlot() {
        availableRoleSlots.forEach((key, value) -> log.info(key + " : " + value));
    }
}
