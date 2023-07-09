package faang.school.godbless.kxnvg.ironthrone;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.kxnvg.ironthrone.Role.KNIGHT;
import static faang.school.godbless.kxnvg.ironthrone.Role.LORD;
import static faang.school.godbless.kxnvg.ironthrone.Role.MAG;
import static faang.school.godbless.kxnvg.ironthrone.Role.PROSTITUTE;
import static faang.school.godbless.kxnvg.ironthrone.Role.SOLDIER;

@Getter
public class House {

    private String name;
    private List<Role> roles;
    private int freeRoles;

    public House(String name) {
        this.name = name;
        roles = new ArrayList<>(List.of(LORD, KNIGHT, MAG, SOLDIER, PROSTITUTE));
        freeRoles = roles.size();
    }

    public void addRole(Role role) {
        roles.add(role);
        freeRoles++;
    }

    public boolean removeRole(Role role) {
        if (roles.contains(role)) {
            roles.remove(role);
            freeRoles--;
            return true;
        } else {
            return false;
        }
    }
}
