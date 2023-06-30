package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task9;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {

    private final String nameHouse;

    private final int totalRolesKnight;

    private final int totalRolesMage;

    private final int totalRolesLords;

    private final List<Role> rolesKnight = new ArrayList<>();
    private final List<Role> rolesMage = new ArrayList<>();
    private final List<Role> rolesLords = new ArrayList<>();

    public House(String nameHouse, int totalRolesKnight, int totalRolesMage, int totalRolesLords) {
        this.nameHouse = nameHouse;
        this.totalRolesKnight = totalRolesKnight;
        this.totalRolesMage = totalRolesMage;
        this.totalRolesLords = totalRolesLords;
    }

    //false - мест нет, true - есть
    public List<Role> checkRole() {
        List<Role> possibleRoles = new ArrayList<>();
        if (rolesLords.size() < totalRolesLords) {
            possibleRoles.add(Role.LORD);
        }
        if (rolesMage.size() < totalRolesMage) {
            possibleRoles.add(Role.MAGE);
        }
        if (rolesKnight.size() < totalRolesKnight) {
            possibleRoles.add(Role.KNIGHT);
        }
        return possibleRoles;
    }

    public void addRole(Role role) {
        switch (role) {
            case LORD -> rolesLords.add(role);
            case MAGE -> rolesMage.add(role);
            case KNIGHT -> rolesKnight.add(role);
        }
    }

    public void removeRole(Role role) {
        switch (role) {
            case LORD -> rolesLords.remove(role);
            case MAGE -> rolesMage.remove(role);
            case KNIGHT -> rolesKnight.remove(role);
        }
    }
}
