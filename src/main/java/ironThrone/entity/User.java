package ironThrone.entity;

import ironThrone.enumeration.Role;

public class User {
    private String name;
    private House house;
    private Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void joinHouse(House house) throws InterruptedException {
        if (house != null) {
            System.out.println("Выходим из прошлого дома...");
            leaveHouse();
        }
        house.addRole(role);
        this.house = house;
        System.out.println("Пользователь вошел в дом");
    }

    public void leaveHouse() {
        if (house != null) {
            house.removeRole(role);
            this.house = null;
            System.out.println("Пользователь вышел из дома");
        }
    }
}
