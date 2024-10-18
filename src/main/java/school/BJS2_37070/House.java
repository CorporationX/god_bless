package school.BJS2_37070;

import lombok.Getter;

import java.util.List;
import java.util.Random;

public class House {

    private List<String> roles;
    @Getter
    private int availableRole;

    public House(List<String> roles) {
        this.roles = roles;
        availableRole = roles.size();
    }

    public String addRole(){
        Random random = new Random();
        availableRole--;
        String role = roles.get(random.nextInt(roles.size()));
        roles.remove(role);
        return role;
    }

    public void removeRole(User user) {
        String role = user.getRole();
        roles.add(role);
        availableRole++;
    }
}
