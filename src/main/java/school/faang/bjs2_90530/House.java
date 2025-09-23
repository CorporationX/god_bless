package school.faang.bjs2_90530;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class House {
    private final List<String> availableRoles;
    private final Set<String> occupiedRoles = new HashSet<>();

    public House(List<String> roles) {
        this.availableRoles = new ArrayList<>(roles);
    }

    public synchronized boolean assignRole(String roleName) {
        if (availableRoles.contains(roleName)) {
            availableRoles.remove(roleName);
            occupiedRoles.add(roleName);
            System.out.printf("%s назначена роль: %s%n",
                    Thread.currentThread().getName(), roleName);
            return true;
        }
        System.out.printf("%s не может получить роль: %s (недоступна или занята)%n",
                Thread.currentThread().getName(), roleName);
        return false;
    }

    public synchronized boolean releaseRole(String roleName) {
        if (occupiedRoles.contains(roleName)) {
            occupiedRoles.remove(roleName);
            availableRoles.add(roleName);
            System.out.printf("%s освободилась роль: %s%n",
                    Thread.currentThread().getName(), roleName);
            return true;
        }
        System.out.printf("%s не может освободить роль: %s (не была занята)%n",
                Thread.currentThread().getName(), roleName);
        return false;
    }
}
