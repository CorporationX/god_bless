package school.faang.bjs248887;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final String name;
    private List<String> roles;
    private int rolesCounter;
    private final Object lock = new Object();

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = new ArrayList<>(roles);
        this.rolesCounter = roles.size();
    }

    public void addRole(String role) {
        synchronized (lock) {
            roles.add(role);
            rolesCounter++;
            lock.notifyAll();
        }
    }

    public void removeRole(String role) {
        synchronized (lock) {
            roles.remove(role);
            rolesCounter--;
        }
    }
}
