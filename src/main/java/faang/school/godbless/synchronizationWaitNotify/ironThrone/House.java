package faang.school.godbless.synchronizationWaitNotify.ironThrone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class House {
    private Map<RoleUser, Integer> map;

    public House() {
        this.map = new HashMap<>();
    }

    public synchronized void addRole(RoleUser roleUser) {
        if (map.getOrDefault(roleUser, 0) == 0) {
            System.out.println("Роль: " + roleUser + " сейчас недоступна!");
            return;
        }

        map.put(roleUser, map.get(roleUser) - 1);
    }

    public synchronized void removeRole(RoleUser roleUser) {
        if (!map.containsKey(roleUser)) {
            System.out.println("Роли " + roleUser + " нет в заданном доме!");
            return;
        }

        map.put(roleUser, map.get(roleUser) + 1);
        this.notify();
    }

    public synchronized List<RoleUser> getAvailableRoles() {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .toList();
    }
}
