package faang.school.godbless.ironthroneatanycost2978;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class House {
    @Getter private String name;
    @Getter private List<String> rolesAvailableList;
    private int rolesAvailableQuantity;
    private static List<House> HOUSES = createHouseList();
    private final Object ROLES_LOCK = new Object();

    public House(String name, List<String> rolesAvailableList, int rolesAvailableQuantity) {
        this.name = name;
        this.rolesAvailableList = rolesAvailableList;
        this.rolesAvailableQuantity = rolesAvailableQuantity;
    }

    public void addRole() {
        synchronized (ROLES_LOCK) {
            this.setRolesAvailableQuantity(this.getRolesAvailableQuantity() - 1);
            System.out.println("Slots left: " + this.getRolesAvailableQuantity() + " | House: " + this.getName());
        }
    }

    public void removeRole() {
        synchronized (ROLES_LOCK) {
            this.setRolesAvailableQuantity(this.getRolesAvailableQuantity() + 1);
        }
    }

    public int getRolesAvailableQuantity() {
        synchronized (ROLES_LOCK) {
            return this.rolesAvailableQuantity;
        }
    }

    public void setRolesAvailableQuantity(int rolesAvailableQuantity) {
        synchronized (ROLES_LOCK) {
            this.rolesAvailableQuantity = rolesAvailableQuantity;
        }
    }

    private static List<String> createRolesList() {
        return new ArrayList<>(List.of(
                "Knight",
                "Mage",
                "Meister",
                "Scout",
                "Assassin"
        ));
    }

    public boolean isAvailableToEnter() {
        return this.getRolesAvailableQuantity() > 0;
    }

    public static List<House> getHouseList() {
        return HOUSES;
    }

    private static List<House> createHouseList() {
        return new ArrayList<>(List.of(
                new House("Baratheons", createRolesList(), 5),
                new House("Starks", createRolesList(), 5),
                new House("Lannisters", createRolesList(), 5)
        ));
    }
}
