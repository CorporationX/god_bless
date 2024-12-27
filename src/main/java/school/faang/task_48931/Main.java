package school.faang.task_48931;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.LORD);
        roles.add(Role.MAGE);
        roles.add(Role.SWORDSMAN);

        House house = new House(roles);

        User user1 = new User("Ivan");
        User user2 = new User("Dima");
        User user3 = new User("Masha");
        User user4 = new User("John");

        Thread t1 = new Thread(() -> user1.joinHouse(house));
        final Thread t2 = new Thread(() -> user2.joinHouse(house));
        final Thread t3 = new Thread(() -> user3.joinHouse(house));

        Thread t4 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                user4.joinHouse(house);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t4.start();
        User user5 = new User("Maks");
        Thread t5 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                user5.joinHouse(house);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t5.start();
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(7000);
            user1.leaveHouse(house);
            Thread.sleep(3000);
            user3.leaveHouse(house);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
