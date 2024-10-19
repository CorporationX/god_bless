package school.faang.BJS2_37096;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Data
public class House {
    private final Logger logger = Logger.getLogger(House.class.getName());
    private List<String> roles = new ArrayList<>();
    private int numberOfRoles;

    public House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
        this.numberOfRoles = roles.size();
    }

    public synchronized String addRole() throws InterruptedException {
        while (numberOfRoles == 0) {
            wait();
        }
        numberOfRoles--;
        String role = roles.remove(0);
        return role;
    }

    public synchronized void removeRole(String role) {
        numberOfRoles++;
        roles.add(role);
        notifyAll();
    }
}
