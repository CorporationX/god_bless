package faang.school.godbless.synchronize.ironThrone;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Data
public class User {
    private String name;
    private House.Role role;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) {
        try {
            boolean ifPossible = house.getRoles().size() < house.getAmountAvailableRoles();
            if (ifPossible) {
                this.house = house;
                house.addRole(this);
            } else {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void leaveHouse() {
        try {
            int timeout = new Random().nextInt(10);
            TimeUnit.SECONDS.sleep(timeout);
            this.house.removeRole(this);
            this.house = null;
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
