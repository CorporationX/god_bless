package school.faang.sprint_3.bjs2_37370_ironThrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Getter
public class House {
    private final Set<String> availableRoles = new HashSet<>();
    private final String name;

    public House(String name, Set<String> roles) {
        this.name = name;
        this.availableRoles.addAll(roles);
    }

    public void addAvailableRole(String role) {
        availableRoles.add(role);
    }

    public void removeAvailableRole(String role) {
        availableRoles.remove(role);
    }
}
