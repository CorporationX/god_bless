package faang.school.godbless.BJS224176;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Role> roleList = Arrays.asList(Role.LORD, Role.KNIGHT, Role.MAGE, Role.ARCHER);
        House house = new House(roleList);

        User user1 = new User("John", house);
        User user2 = new User("Alice", house);
        User user3 = new User("Bob", house);
        User user4 = new User("Diana", house);
        User user5 = new User("Eve", house);

        new Thread(() -> {
            try {
                user1.joinHouse();
                System.out.println(user1.getName() + " joined the house.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                user2.joinHouse();
                System.out.println(user2.getName() + " joined the house.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                user3.joinHouse();
                System.out.println(user3.getName() + " joined the house.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                user4.joinHouse();
                System.out.println(user4.getName() + " joined the house.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                user5.joinHouse();
                System.out.println(user5.getName() + " joined the house.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            user1.leaveHouse();
            System.out.println(user1.getName() + " left the house.");
        }).start();
    }
}
