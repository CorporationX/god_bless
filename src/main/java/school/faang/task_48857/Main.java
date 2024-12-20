package school.faang.task_48857;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        House house = new House("House-1", Arrays.asList(Role.LORD, Role.KNIGHT, Role.MAGE));

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");

        Thread thread1 = new Thread(() -> {
            user1.joinHouse(house);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user1.leaveHouse();
        });

        Thread thread2 = new Thread(() -> {
            user2.joinHouse(house);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user2.leaveHouse();
        });

        Thread thread3 = new Thread(() -> {
            user3.joinHouse(house);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user3.leaveHouse();
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All users have completed their actions.");
    }
}
