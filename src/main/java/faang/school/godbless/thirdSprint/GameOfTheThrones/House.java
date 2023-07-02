package faang.school.godbless.thirdSprint.GameOfTheThrones;

import lombok.Value;

import java.util.Map;

@Value
public class House {
    Map<String, Integer> roles;

    public void addRole(String role) {
        roles.computeIfPresent(role, (key, value) -> value - 1);
        System.out.println("Available roles: " + roles);
    }

    public void removeRole(String role) {
        roles.computeIfPresent(role, (key, value) -> value + 1);
        System.out.println("Available roles: " + roles);
    }
}
