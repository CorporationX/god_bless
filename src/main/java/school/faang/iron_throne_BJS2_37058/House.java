package school.faang.iron_throne_BJS2_37058;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class House {

    private List<String> roles;
    private int freeRoles;

    public synchronized void addRole(String role) {
        while (freeRoles <= 0) {
            try {
                System.out.println("All roles are busy");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        System.out.printf("Role %s was taken\n", role);
        freeRoles--;
        roles.remove(role);
    }

    public synchronized void removeRole(String role) {
        freeRoles++;
        roles.add(role);
        System.out.printf("Role %s is free\n", role);
        notifyAll();
    }
}
