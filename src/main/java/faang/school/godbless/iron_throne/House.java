package faang.school.godbless.iron_throne;

import lombok.Getter;

import java.util.List;

@Getter
public class House {
    private List<String> roles;
    private String houseName;
    private int availableRoles;

    public House(String houseName, List<String> roles) {
        this.houseName = houseName;
        this.roles = roles;
        this.availableRoles = roles.size();
    }

    public void addRole(String role) {
        roles.add(role);
        availableRoles++;
    }

    public void removeRole(String role) {
        roles.remove(role);
        availableRoles--;
    }
}
