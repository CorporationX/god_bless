package school.faang.theirontronatanycost.maincode;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private List<String> roles;
    private int rolesCount;

    public House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
        this.rolesCount = roles.size();
    }

    public synchronized void addRole(String role) {
        roles.remove(role);
        rolesCount--;
    }

    public synchronized void removeRole(String role) {
        roles.add(role);
        rolesCount++;
        this.notifyAll();
    }
}
