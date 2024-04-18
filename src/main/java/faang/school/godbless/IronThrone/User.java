package faang.school.godbless.IronThrone;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void joinHouse(House house) {
        this.house = house;
        System.out.println(name + " want to join house " + house.getName());
        house.addRole(role);
        System.out.println(name + " joined the house " + house.getName() + " with role - " + role);
    }

    public void leaveHouse() {
        if (house == null) {
            return;
        }
        house.removeRole(role);
        System.out.println(name + " left the house - " + house.getName());
        house = null;
    }
}
