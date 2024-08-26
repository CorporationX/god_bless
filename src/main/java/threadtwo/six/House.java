package threadtwo.six;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class House {

    private String name;
    private Map<String, Integer> rolesMap;

    public synchronized void assignRole(String role) {
        if (rolesMap.containsKey(role) && rolesMap.get(role) > 0) {
            rolesMap.put(role, rolesMap.get(role) - 1);
        } else {
            throw new IllegalArgumentException("(Assign)Role " + role + " does not exist.");
        }
    }

    public synchronized void releaseRole(String role) {
        if (rolesMap.containsKey(role)) {
            rolesMap.put(role, rolesMap.get(role) + 1);
        } else {
            throw new IllegalArgumentException("(release)Role " + role + " does not exist.");
        }
    }

    public synchronized boolean isHaveFreeRole() {
        return rolesMap.entrySet().stream()
                .anyMatch(entry -> entry.getValue() > 0);
    }

    public synchronized List<String> getListFreeRole() {
        return rolesMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .toList();
    }
}
