package faang.school.godbless.synchronize.ironThrone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class House {
    private List<Role> roles;
    private int amountAvailableRoles;

    public void addRole(User user) {
        Role role = getRole();
        roles.add(role);
        user.setRole(role);
        amountAvailableRoles--;
        System.out.println(user.getName() + " joined the house and role " + role + " was added");
    }

    public void removeRole(User user) {
        Role role = user.getRole();
        roles.remove(role);
        user.setRole(null);
        amountAvailableRoles++;
        System.out.println(user.getName() + " left the house and role " + role + " was removed");
    }

    private static Role getRole() {
        return Role.values()[new Random().nextInt(Role.values().length)];
    }

    public enum Role {
        ROLE_MAGE, ROLE_KNIGHT, ROLE_WIZARD, ROLE_GOD, ROLE_HUMAN, ROLE_LORD, ROLE_SORCERER, ROLE_DRAGON, ROLE_WITCH, ROLE_KING
    }
}
