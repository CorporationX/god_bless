package faang.school.godbless.the_iron_throne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String name;
    private House house;
    private String role;

    public void joinHouse(House house, String role) {
        house.addRole(role, this);
    }

    public void leaveHouse(House house) {
        house.removeRole(role, this);
    }

    public User(String name) {
        this.name = name;
    }
}
