package school.faang.iron.throne;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        if (house == null) {
            throw new IllegalArgumentException("house не может быть null");
        }
        this.house = house;
        String receivedRole = house.addRole(name);
        this.role = receivedRole;
    }

    public void leaveHouse() {
        if (house == null) {
            throw new IllegalArgumentException("пользователь " + name + " не принадлежит никакому из домов");
        }
        house.removeRole(name);
        this.role = null;
    }
}
