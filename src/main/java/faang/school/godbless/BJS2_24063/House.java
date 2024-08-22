package faang.school.godbless.BJS2_24063;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {

    private final List<String> roles = new ArrayList<>(List.of("Swordsman", "Alchemist", "King", "Support", "Poor man"));

    public String addRole() {
        Random random = new Random();
        int index = random.nextInt(roles.size());
        return roles.remove(index);
    }

    public void removeRole(String role) {
        roles.add(role);
    }

    public String getAvailableRoles() {
        return roles.toString();
    }
}
