package faang.school.godbless.bjs2_5632;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class User {

    private String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Role role) {
            house.addRole(role, this);
    }

    public void leaveHouse(House house) {
        house.removeRole(role, this);
    }
}
