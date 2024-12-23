package school.faang.sprint_3.task_43560;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private final List<Role> roles;
    private final List<Role> availableRoles;

    private final String name;

    public House(String name) {
        this.name = name;
        this.roles = new ArrayList<>(List.of(Role.KNIGHT, Role.LORD, Role.MAGICIAN));
        this.availableRoles = new ArrayList<>(roles);
    }

    public void addRole(Role role) {
        availableRoles.remove(role);
    }

    public void removeRole(Role role) {
        availableRoles.add(role);
    }
}
