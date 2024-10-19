package school.faang.gameofthrones;

import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class House {
    private final List<String> roles;
    private int availableRolesCount;
    private final String name;

    public House(String houseName, List<String> roles) {
        this.name = houseName;
        this.roles = roles;
        this.availableRolesCount = roles.size();
    }

    public synchronized String addRole() {
        String role = roles.remove(new Random().nextInt(availableRolesCount));
        this.availableRolesCount--;
        return role;
    }

    public synchronized void removeRole(String role) {
        roles.add(role);
        this.availableRolesCount++;
        this.notifyAll();
    }
}
