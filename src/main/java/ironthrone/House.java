package ironthrone;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class House {
    @Getter
    private final String name;
    private final Map<HouseRole, Integer> availableRoleSlots;

    public synchronized void addRole(HouseRole role) {
        availableRoleSlots.put(role, availableRoleSlots.get(role) - 1);
    }

    public synchronized void removeRole(HouseRole role) {
        availableRoleSlots.merge(role, 1, Integer::sum);
        this.notifyAll();
    }

    public synchronized boolean isAnyRoleAvailable() {
        return availableRoleSlots.values().stream()
                .anyMatch(count -> count > 0);
    }

    public synchronized List<HouseRole> getAvailableRoles() {
        return availableRoleSlots.keySet().stream()
                .filter(r -> availableRoleSlots.get(r) > 0)
                .toList();
    }

    public void printRolesSlot() {
        availableRoleSlots.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
