package dima.evseenko.throne;

import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Role role) throws InterruptedException {
        synchronized (house) {
            if (house.getRoles().containsKey(role)) {
                System.out.printf("Роль %s уже занята, пользователь %s ожидает...%n", role, name);
                house.wait();
                joinHouse(house, role);
            } else {
                System.out.printf("Пользователь %s занял роль %s%n", name, role);
                house.addRole(this, role);
                this.house = house;
                this.role = role;
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.printf("Пользователь %s освободил роль %s%n", name, role);
            house.removeRole(this);
            house.notify();
            house = null;
            role = null;
        }
    }
}
