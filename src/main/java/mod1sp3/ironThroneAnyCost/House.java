package mod1sp3.ironThroneAnyCost;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class House {
    private String name;
    private List<String> roleInHouseList;
    private final Set<String> availableRoles = new HashSet<>();
    private final Object lock = new Object();

    public House(String name, List<String> roleInHouseList) {
        this.name = name;
        this.roleInHouseList = roleInHouseList;
        availableRoles.addAll(roleInHouseList);
    }

    public void removeAvailableRole(String role) {
        synchronized (lock) {
            availableRoles.remove(role);
        }
    }

    public void addAvailableRole(String role) {
        synchronized (lock) {
            availableRoles.add(role);
            lock.notify();
        }
    }
}
