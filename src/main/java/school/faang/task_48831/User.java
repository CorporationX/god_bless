package school.faang.task_48831;

import lombok.Data;

@Data

public class User {
    private String name;
    private House house;
    private Role busyRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        while (true) {
            synchronized (house) {
                Role desiredRole = house.getRoles().stream()
                        .filter(role -> role.getUser() == null)
                        .findAny()
                        .orElse(null);

                if (desiredRole == null) {
                    try {
                        house.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Ошибка выполнения кода: " + e);
                    }
                } else {
                    desiredRole.setUser(this);
                    busyRole = desiredRole;
                    this.house = house;
                    break;
                }
            }
        }
    }

    public void leaveHouse(House house) {
        if (this.house == null || busyRole == null) {
            System.out.println("У пользователя нет дома или роли");
            return;
        }

        synchronized (house) {
            this.house = null;
            busyRole.setUser(null);
            busyRole = null;
            house.notifyAll();
        }
    }
}
