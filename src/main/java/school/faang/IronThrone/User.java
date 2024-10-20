package school.faang.IronThrone;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        this.house = house;
        System.out.println(name + " trying to join house");
        this.role = this.house.getRole();
        System.out.println(name + " joined house as " + role);
    }

    public void leaveHouse() {
        System.out.println(name + " is leaving house");
        house.removeRole(role);
        house = null;
    }
}
