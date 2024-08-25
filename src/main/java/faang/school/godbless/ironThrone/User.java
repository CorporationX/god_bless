package faang.school.godbless.ironThrone;

import lombok.Getter;

import java.util.List;

@Getter
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        List<String> roles = House.getRoles();
        String chosenRole = roles.get((int) (roles.size() * Math.random()));//имитация выбора
        house.joinUser(chosenRole);

        this.house = house;
        this.role = chosenRole;
        System.out.println("user " + name + " join house with role " + role);
    }

    public void leaveHouse() {
        if (house == null || role == null) {
            throw new IllegalArgumentException();
        } else {
            house.leaveUser(role);
            house = null;
            role = null;
            System.out.println("user " + name + " leave house");
        }
    }
}
