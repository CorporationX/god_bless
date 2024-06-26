package faang.school.godbless.multithreading.tron;

import java.util.List;
import java.util.Random;

public class User {
    private static final Object lock = new Object();
    private String name;
    private House house;
    private String role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() {
        synchronized (lock) {
            System.out.println(name + " пытается получить роль");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (house.getCountAvailableRoles() == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            List<String> availableRoles = house.getAvailableRoles();
            int index = new Random().nextInt(availableRoles.size());
            role = availableRoles.get(index);
            house.addRole(role);
            System.out.println(name + " получил роль " + role);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            house.removeRole(role);
            lock.notifyAll();
            System.out.println(name + " освободил роль " + role);
            role = null;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
