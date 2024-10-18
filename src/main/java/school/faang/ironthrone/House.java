package school.faang.ironthrone;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private List<String> roles;
    private Integer countRoles;
    private Random random = new Random();

    public House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
        this.countRoles = roles.size();
    }

    public String addRole() {
        String role = roles.get(random.nextInt(roles.size()));

        roles.remove(role);
        countRoles--;

        return role;
    }

    public void removeRole(String role) {
        roles.add(role);
        countRoles++;
        this.notifyAll();
    }
}