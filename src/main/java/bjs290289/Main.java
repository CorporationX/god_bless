package bjs290289;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        House house = new House(new ArrayList<>(Arrays.asList("Lord", "Knight", "Mage")));
        List<Thread> players = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            User user = new User("Player-" + i);
            Thread t = new Thread(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep((long) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                user.leaveHouse();
            }, "Thread-" + i);
            players.add(t);
            t.start();
        }

        for (Thread t : players) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("All players have left the house. Game over!");
    }
}
