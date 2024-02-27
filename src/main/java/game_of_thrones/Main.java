package game_of_thrones;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> availableRoles = List.of("Lord", "Knight", "Mage");
        House house = new House(availableRoles);

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");

        Thread thread1 = new Thread(() -> user1.joinHouse(house, "Lord"));
        Thread thread2 = new Thread(() -> user2.joinHouse(house, "Knight"));
        Thread thread3 = new Thread(() -> user3.joinHouse(house, "Knight"));

        thread3.start();
        thread1.start();
        thread2.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        user1.leaveHouse(user1.getHouse());
        user3.leaveHouse(user3.getHouse());

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
