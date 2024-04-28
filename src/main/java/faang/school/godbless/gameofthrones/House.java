package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class House {
    private final Map<Role, Integer> houseSlots;

    public House() {
        houseSlots = initialize();
    }

    public synchronized boolean isHaveEmptySlots() {
        return houseSlots.values().stream()
                .anyMatch(i -> i > 0);
    }

    public synchronized void addRole(Role role) {
        houseSlots.put(role, houseSlots.get(role) - 1);
    }

    public synchronized void removeRole(Role role) {
        houseSlots.put(role, houseSlots.get(role) + 1);
        this.notifyAll();
    }

    public synchronized Optional<Role> getPriorityRole() {
        return houseSlots.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .sorted()
                .findFirst();
    }

    private Map<Role, Integer> initialize() {
        Map<Role, Integer> map = new HashMap<>();
        map.put(Role.KING, 1);
        map.put(Role.KNIGHT, 3);
        map.put(Role.MAGE, 5);
        return map;
    }
}
