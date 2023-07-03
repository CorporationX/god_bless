package faang.school.godbless.multithreading.iron_throne;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Random random;
    private final String name;
    private final House house;
    private String role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
        this.random = new Random();
    }

    public void joinHouse() {
        synchronized (house) {
            while (house.getAvailableRolesCount() == 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }

            role = house.getRoles().get(random.nextInt(house.getRoles().size()));
            System.out.println(name + " chooses role: " + role);

            house.addRole();
        }

        try {
            Thread.sleep(random.nextInt(1000, 5000));
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        leaveHouse();
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " leaves the house");
            house.removeRole();
            role = null;
        }
    }
}
