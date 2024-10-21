package school.faang.sprint_3.bjs2_37370_ironThrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class House {
    @Getter
    private final Object lock = new Object();
    private final Set<String> availableRoles = new HashSet<>();
    @Getter
    private final String name;

    public House(String name, Set<String> roles) {
        this.name = name;
        this.availableRoles.addAll(roles);
    }

    public void addAvailableRole(String role) {
        synchronized (lock) {
            availableRoles.add(role);
        }
    }

    public void removeAvailableRole(String role) {
        synchronized (lock) {
            availableRoles.remove(role);
        }
    }

    public Set<String> getAvailableRoles() {
        synchronized (lock) {
            return Set.copyOf(availableRoles);
        }
    }
}
