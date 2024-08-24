package faang.school.godbless.BJS2_24310;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class User {
    private House house;
    private final String name;
    private Role role;

    public User(House house, String name) {
        this.house = house;
        this.name = name;
    }

    public void joinHouse() {
        Object lock = house.getLock();
        Random rand = new Random();
        synchronized (lock) {
            while (house.getFreeRoles() < 1) {
                System.out.println("No available roles for " + name);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            role = house.getRoles().get(rand.nextInt(house.getRoles().size()));
            house.addRole();
            System.out.println(name + " joined the house with role " + role.getName());
        }
    }

    public void leaveHouse() {
        synchronized (house.getLock()) {
            house.removeRole(this);
            house.getLock().notifyAll();
            house = null;
        }
    }
}
