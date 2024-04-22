package faang.school.godbless.iron_throne;

import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private HouseRole role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, HouseRole houseRole) {
        house.addRole(houseRole, this);
    }

    public void leaveHouse(House house) {
        house.removeRole(role, this);
    }
}