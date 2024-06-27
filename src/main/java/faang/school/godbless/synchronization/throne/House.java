package faang.school.godbless.synchronization.throne;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class House {

    private String name;
    private Map<Role, Integer> rolesMap;

    public  void addRole(Role role) {
        rolesMap.computeIfPresent(role, (k, v) -> v - 1);
        System.out.println("add role: " + role + " vacant: " + rolesMap.get(role));
    }

    public void removeRole(Role role) {
        rolesMap.computeIfPresent(role, (k, v) -> v + 1);
        System.out.println("removeRole: " + role + " vacant: " + rolesMap.get(role));
    }
}
