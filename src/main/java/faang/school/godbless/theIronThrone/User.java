package faang.school.godbless.theIronThrone;

import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) {
        house.addRole(role, this);
    }

    public void leaveHouse(House house) {
        house.removeRole(role, this);
    }

}
