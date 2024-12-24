package school.faang.sprint3.task49100.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.List;

@EqualsAndHashCode
//@ToString
public class House {

    @Getter
    private final String name;
    private final List<Role> availableRoles;
    @Getter
    private Integer availableRolesQuantity;
    private final Object listLock = new Object();

    public House(String name, List<Role> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        this.availableRolesQuantity = availableRoles.size();
    }

    public Role addRole(Role role) {
        synchronized (listLock) {
            if (!availableRoles.isEmpty()) {
                if (availableRoles.remove(role)) {
                    availableRolesQuantity = availableRoles.size();
                    return role;
                } else {
                    return null;
                }
            } else {
                try {
                    listLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }
        }
    }

    public void removeRole(Role role) {
        synchronized (listLock) {
            availableRoles.add(role);
            availableRolesQuantity = availableRoles.size();
            listLock.notify();
        }
    }
}
