package faang.school.godbless.BJS2_1281;

import lombok.Data;

import java.util.Map;
import java.util.stream.Collectors;

@Data
public class House {
    private Map<Role, Integer> rolesAndAvailability;
    private int totalAvailableSpaces;
    private String name;

    public House(String name) {
        this.name = name;
        this.rolesAndAvailability = Role.getList().stream()
                .collect(Collectors.toMap(role -> role, count -> 1));
        totalAvailableSpaces = rolesAndAvailability.values().stream().mapToInt(Integer::intValue).sum();
    }

    public House(String name, Map<Role, Integer> rolesAndAvailability) {
        this.name = name;
        this.rolesAndAvailability = rolesAndAvailability;
        this.totalAvailableSpaces = rolesAndAvailability.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void takeRole(Role role) {
        rolesAndAvailability.computeIfPresent(role, (key, value) -> value - 1);
        totalAvailableSpaces--;
    }

    public void giveRole(Role role) {
        synchronized (this) {
            rolesAndAvailability.computeIfPresent(role, (key, value) -> value + 1);
            totalAvailableSpaces++;
            this.notifyAll();
        }
    }

    public boolean hasAvailableRoles(Role role) {
        return rolesAndAvailability.getOrDefault(role, 0) > 0;
    }

    public int getAvailableSpacesByRole(Role role) {
        return rolesAndAvailability.getOrDefault(role, 0);
    }
}