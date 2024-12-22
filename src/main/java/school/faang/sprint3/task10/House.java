package school.faang.sprint3.task10;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class House {
    private String name;
    private List<String> roles = new ArrayList<>();
    private int rolesAvailable;
    private final Object lock = new Object();

    public House(List<String> roles, String name) {
        this.setName(name);
        this.setRoles(roles);
        this.setRolesAvailable(roles.size());
    }

    public void addRole(String role) {
        synchronized (lock) {
            this.roles.add(role);
            this.setRolesAvailable(this.getRolesAvailable() - 1);
        }
    }

    public void removeRole() {
        synchronized (lock) {
            this.setRolesAvailable(this.getRolesAvailable() + 1);
        }
    }
}
