package faang.school.godbless.multithreading.iron_throne;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Runnable{
    private final String name;
    private final House house;
    private String role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public void run() {
        joinHouse();

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        leaveHouse();
    }

    public void joinHouse() {
        synchronized (house) {
            while (house.getAvailableRolesCount().get() == 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }

            role = house.getRoles().get(new Random().nextInt(house.getRoles().size()));
            System.out.println(name + " chooses role: " + role);

            house.addRole();
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " leaves the house");
            house.removeRole();
            role = null;
            house.notifyAll();
        }
    }
}
