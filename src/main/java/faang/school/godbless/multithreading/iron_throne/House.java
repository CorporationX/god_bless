package faang.school.godbless.multithreading.iron_throne;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class House {
    private String name;
    private List<String> availableRoles;

    public House(String name) {
        this.name = name;
        availableRoles = new ArrayList<>(Arrays.asList("Lord", "Knight", "Mage"));
    }

    public void removeAvailableRole(String role) {
        availableRoles.remove(role);
    }

    public void addAvailableRole(String role) {
        availableRoles.add(role);
    }
}
