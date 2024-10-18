package school.BJS2_37070;

import lombok.Getter;
import lombok.Setter;

public class User {

    private String name;
    private String house;
    @Setter
    @Getter
    private String role;

    public User(String name, String house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            if (house.getAvailableRole() == 0) {
                System.out.println("Ожидание пока освободится роль");
                house.wait();
            }
            this.setRole(house.addRole());
            System.out.println("Пользователь " + name + " выбрал роль " + role);
        }
    }

    public void leaveHouse(House house) throws InterruptedException {
        Thread.sleep(5000);
        synchronized (house) {
            System.out.println("Освобождается роль: " + role);
            house.removeRole(this);
            house.notify();
        }
    }
}