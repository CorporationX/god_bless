package faang.school.godbless.BJS2_5880;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final String name;
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
