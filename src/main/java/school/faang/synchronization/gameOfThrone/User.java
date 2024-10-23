package school.faang.synchronization.gameOfThrone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String role;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            try {
                while (house.getCountOfAvailableRoles() == 0) {
                    System.out.println(name + " is waiting for his/her role");
                    house.wait();
                }
                this.role = house.addRole();
                this.house = house;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " leaves home and vacates the role " + role);
            house.removeRole();
            house.notifyAll();
        }
        this.house = null;
        this.role = null;
    }

}
