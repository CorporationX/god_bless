package school.faang.irontron;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) throws InterruptedException {
        synchronized(house) {
            while (!house.getAvailableRoles().contains(role)) {
                System.out.println(this.name + " Пожалуйста ожидайте своей очереди место " + role + " занято");
                house.wait();
            }
            house.removeRole(role);
            this.house = house;
            this.role = role;
            System.out.println(this.name + " присоединился к дому и получил звание " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (this.role != null) {
                System.out.println(this.name + " ушел из дома и отказался от звания " + this.role);
                house.addRole(role);
                this.house = null;
                this.role = null;
                house.notifyAll();
            }
        }
    }
}
