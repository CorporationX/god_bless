package faang.school.godbless.bjs2_24231;

import lombok.Getter;

import java.util.Map;

@Getter
public class House {
    private Map<Role, Integer> roles;
    private int rolesAmount;

    public House(Map<Role, Integer> roles) {
        this.roles = roles;
        rolesAmount = roles.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Role removeRole() {
        var role = findFirstAvailableRole();
        roles.merge(role, 1, (oldValue, newValue) -> oldValue - newValue);
        rolesAmount--;
        return role;
    }

    public void addRole(Role role) {
        roles.merge(role, 1, Integer::sum);
        rolesAmount++;
        if (rolesAmount == 1) {
            notifyAll();
        }
    }

    private Role findFirstAvailableRole() {
        var entryToAssign = roles.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .findFirst()
                .orElse(null);

        return entryToAssign.getKey();
    }

    public boolean hasNoAvailableRoles() {
        return rolesAmount == 0;
    }
}
