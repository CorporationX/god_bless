package school.faang.iron.throne;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

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
        Random random = new Random();
        synchronized (house) {
            List<String> availableRoles = house.getAvailableRoles();
            role = availableRoles.get(random.nextInt(availableRoles.size()));
            house.addRole(name, role);
        }
    }

    public void leaveHouse() {
        if (house == null) {
            throw new IllegalArgumentException("пользователь " + name + " не принадлежит никакому из домов");
        }
        house.removeRole(name);
    }
}
