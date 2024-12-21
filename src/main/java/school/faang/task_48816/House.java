package school.faang.task_48816;

import lombok.Getter;
import school.faang.exception.CheckException;

import java.util.List;
import java.util.Random;

@Getter
public class House {
    private final String name;
    private final List<String> availableRoles;
    private int availableRoleCount;


    public House(String name, List<String> roles) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("houseName");
        }
        if (roles == null) {
            throw new CheckException("roles");
        }

        this.name = name;
        this.availableRoles = roles;
        this.availableRoleCount = roles.size();
    }

    public void addRole() {
        availableRoleCount++;
    }

    public String removeRole() {
        Random random = new Random();
        String role = availableRoles.get(random.nextInt(availableRoles.size()));
        availableRoleCount--;
        return role;
    }
}
