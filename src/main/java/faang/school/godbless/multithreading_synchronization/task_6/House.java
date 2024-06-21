package faang.school.godbless.multithreading_synchronization.task_6;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class House {
    private final Map<Role, Integer> roles;

    public void addRole(Role role) {
        roles.computeIfPresent(role, (k, v) -> v - 1);
        System.out.printf("%s adding user...\n", role.toString());
    }

    public void removeRole(Role role) {
        roles.computeIfPresent(role, (k, v) -> v + 1);
        System.out.printf("%s removing user...\n", role.toString());
    }

    public boolean roleIsIsOccupied(Role role) {
        return roles.get(role) == 0;
    }
}
