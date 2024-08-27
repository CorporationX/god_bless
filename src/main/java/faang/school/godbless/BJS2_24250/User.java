package faang.school.godbless.BJS2_24250;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String desiredRole) {
        this.house = house;
        synchronized (house) {
            while (!house.takeRole(desiredRole)) {
                try {
                    System.out.println(name + " ждет освобождения роли " + desiredRole + " в доме " + house.getName());
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.role = desiredRole;
            System.out.println(name + " присоединился к дому " + house.getName() + " в роли " + role);
        }
    }
    public void leaveHouse() {
        if (house != null && role != null) {
            synchronized (house) {
                house.removeRole(role);
                System.out.println(name + " покинул дом " + house.getName() + " и освободил роль " + role);
                this.role = null;
                this.house = null;
            }
        }
    }
}
