package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class GameOfThrones {
    public static void main(String[] args) {
        House house = new House();
        house.addRole("Lord");
        house.addRole("Knight");
        house.addRole("Mage");

        final int NUM_THREADS = 10;
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= NUM_THREADS; i++) {
            User user = new User("User " + i, house);
            users.add(user);
        }

        for (User user : users) {
            Thread thread = new Thread(() -> {
                user.joinHouse();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.leaveHouse();
            });
            thread.start();
        }
    }
}
