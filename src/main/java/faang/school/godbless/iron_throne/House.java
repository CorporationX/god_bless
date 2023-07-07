package faang.school.godbless.iron_throne;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class House {
    private String name;
    public List<String> roles;
    private int availableRoles;

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
        this.availableRoles = 5;
    }
    public House() {

    }


    public void addRole(String userRole) {
        roles.remove(userRole);
        availableRoles--;
    }

    public void removeRole(String role) {
        roles.add(role);
        availableRoles++;
    }
}
