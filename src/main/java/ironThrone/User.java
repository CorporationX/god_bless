package ironThrone;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class User {
    private static final List<String> ROLES = List.of("King", "Swordman", "Archer", "Salesman");
    private static final Random random = new Random();
    private String name;
    private House house;
    private String role;
    private final Object lock = new Object();

    public User(String name) {
        this.name = name;
        this.house = null;
        this.role = "";
    }

    public void joinHouse(House house) {
        if (house == null) {
            throw new NullPointerException("House must be exist");
        }
        synchronized (lock) {
            if (house.getAmountRoles() == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            house.addRole(this, ROLES.get(random.nextInt(0, ROLES.size())));
            System.out.printf("\n%s стал %s в доме %s", this.getName(), this.getRole(), this.getHouse().getName());
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            System.out.printf("\n%s вышел с %s в доме %s", this.getName(), this.getRole(), this.getHouse().getName());
            this.getHouse().removeRole(this);
            lock.notify();
        }
    }
}
