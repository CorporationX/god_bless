package school.faang.multithreading.synchron.iron.throne.any.cost;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private List<String> availableRoles;
    private int availableRolesCount;

    public House(List<String> availableRoles) {
        this.availableRoles = new ArrayList<>(availableRoles);
        this.availableRolesCount = availableRoles.size();
    }

    public synchronized void addRole(String role) {
        availableRoles.remove(role);
        availableRolesCount--;
    }

    public synchronized void removeRole(String role) {
        availableRoles.add(role);
        availableRolesCount++;
        this.notifyAll();
    }
}
