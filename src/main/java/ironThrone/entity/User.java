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
            leaveHouse();
        }
        house.addRole(role);
        this.house = house;
        String threadName = Thread.currentThread().getName();
        if (threadName != null) System.out.print(threadName + " ");
        System.out.println("Пользователь вошел в дом");
    }

    public void leaveHouse() {
        if (house != null) {
            house.removeRole(role);
            this.house = null;
            String threadName = Thread.currentThread().getName();
            if (threadName != null) System.out.print(threadName + " ");
            System.out.println("Пользователь вышел из дома");
        } else {
            System.out.println("Больше неоткуда бежать");
        }
    }
}
