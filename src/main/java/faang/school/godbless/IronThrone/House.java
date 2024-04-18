package faang.school.godbless.IronThrone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class House {
    private String name;
    private int availableRolesCount;
    private final List<String> roles;

    public void addRole(String role) {
        synchronized (roles) {
            if (!hasAvailableRoles()) {
                try {
                    roles.wait();
                    System.out.println(name + "'s " + role + " is waiting...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            roles.add(role);
            availableRolesCount--;
        }
    }

    public void removeRole(String role) {
        synchronized (roles) {
            roles.remove(role);
            availableRolesCount++;
            roles.notifyAll();
        }
    }

    public boolean hasAvailableRoles() {
        return availableRolesCount > 0;
    }
}
