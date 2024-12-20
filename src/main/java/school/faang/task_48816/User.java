package school.faang.task_48816;

import school.faang.exception.CheckException;

import java.util.Collections;

public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("userName");
        }

        this.name = name;
    }

    public synchronized void joinHouse(House house) {
        this.house = house;
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println("Произошла ошибка");
                }
            }
            String role = house.getRole();
            this.role = role;
            System.out.println(name + " выбрал роль: " + role);
        }
    }

    public synchronized void leaveHouse() {
        if (house == null) {
            String msg = "Чтобы покинуть дом, пользователь %s должен сначала вступить в какой-нибудь дом";
            throw new CheckException(msg, Collections.singletonList(name));
        }
        synchronized (house) {
            System.out.println(name + " покидает дом и освобождает роль: " + role);
            house.removeRole(role);
            house.notifyAll();
            this.house = null;
            this.role = null;
        }
    }
}
