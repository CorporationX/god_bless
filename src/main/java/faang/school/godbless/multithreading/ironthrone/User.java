package faang.school.godbless.multithreading.ironthrone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private final House house;
    private Role role;

    public User(String name, House house, Role role) {
        this.name = name;
        this.house = house;
        this.role = role;
    }

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            if (this.house.getFreeRoles() == 0){
                System.out.println("> waiting for a free role in house");
                house.wait();
            }


            this.role = this.house.getRoles().get(new Random().nextInt(3));
            System.out.printf("> %s is adding to the house%n", this.role);
            this.house.addRole();
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            this.role = null;
            this.house.removeRole();
        }
    }
}
