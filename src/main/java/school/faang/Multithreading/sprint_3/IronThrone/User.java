package school.faang.Multithreading.sprint_3.IronThrone;

import lombok.Getter;

@Getter

public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("У пользователя должно быть имя");
        }
    }

    public void joinHouse(House house, String role) {
        house.addRole(role, this);

        this.house = house;
        this.role = role;
    }

    public void leaveHouse(House house) {
        house.removeRole(this);

        this.house = null;
        this.role = null;
    }
}