package school.faang.sprint3.task49100.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
public class House {

    @Getter
    private final String name;
    private final List<Role> availableRoles;
    @Getter
    private Integer availableRolesQuantity;

    public House(String name, List<Role> availableRoles) {
        this.name = name;
        this.availableRoles = new ArrayList<>(availableRoles);
        this.availableRolesQuantity = this.availableRoles.size();
    }

    public Role addRole(Role role) {
        synchronized (availableRoles) {
            if (!availableRoles.isEmpty()) {
                if (availableRoles.remove(role)) {
                    availableRolesQuantity = availableRoles.size();
                    return role;
                } else {
                    return null;
                }
            } else {
                try {
                    availableRoles.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }
        }
    }

    public void removeRole(Role role) {
        synchronized (availableRoles) {
            availableRoles.add(role);
            availableRolesQuantity = availableRoles.size();
            availableRoles.notify();
        }
    }
}
