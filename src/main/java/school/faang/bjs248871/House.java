package school.faang.bjs248871;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {

    private final List<String> roles = new ArrayList<>();
    private int countOfRoles;

    public House(List<String> roles) {
        this.roles.addAll(roles);
        countOfRoles = roles.size();
    }

    public synchronized String addRole(String role) {
        roles.add(role);
        countOfRoles++;
        return role;
    }

    public synchronized void removeRole(String role) {
        roles.remove(role);
        countOfRoles--;
    }
}
