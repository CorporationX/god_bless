package faang.school.godbless.iron_throne;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class House {
    private String name;
    public List<String> roles;
    private int availableRoles = 5;

    public House(String name) {
        this.name = name;
        this.roles = new ArrayList<>();
    }


    public void addRole(String role) {
        roles.remove(role);
        availableRoles--;
    }

    public void removeRole(String role) {
        roles.add(role);
        availableRoles++;
    }
}
