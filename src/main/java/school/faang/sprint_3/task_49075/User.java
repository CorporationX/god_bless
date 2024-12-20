package school.faang.sprint_3.task_49075;

import lombok.extern.slf4j.Slf4j;

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
            throw new IllegalArgumentException("Дом не может быть null");
        }
        synchronized (house) {
            while (house.getRoles().isEmpty()) {
                System.out.println("Нет доступных ролей в этом Доме для пользователя " + name);
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток прерван при ожидании освобождения роли");
                }
            }
            this.role = house.addRole();
            this.house = house;
            System.out.println(name + " выбрал роль " + role);
        }
    }

    public void leaveHouse(House house) {
        if (house == null) {
            throw new IllegalArgumentException("Дом не может быть null");
        }
        synchronized (house) {
            System.out.println(name + " покинул Дом и освободил роль " + role);
            house.removeRole(role);
            this.house = null;
            this.role = null;
            house.notifyAll();
        }
    }

}
