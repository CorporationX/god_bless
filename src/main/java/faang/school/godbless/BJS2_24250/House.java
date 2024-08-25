package faang.school.godbless.BJS2_24250;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class House {
    private String name;
    private final Map<String, Integer> roles = new HashMap<>();

    public House(String name) {
        this.name = name;
    }

    public synchronized void addRole(String role, int count) {
        roles.put(role, roles.getOrDefault(role, 0) + count);
        notifyAll();
    }
    public synchronized void removeRole(String role) {
        roles.put(role, roles.getOrDefault(role, 0) + 1);
        notifyAll();
    }
    public synchronized boolean takeRole(String role) {
        int count = roles.getOrDefault(role, 0);
        if (count > 0) {
            roles.put(role, count - 1);
            return true;
        }
        return false;
    }
}
