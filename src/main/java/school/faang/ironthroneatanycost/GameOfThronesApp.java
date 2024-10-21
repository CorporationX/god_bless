package school.faang.ironthroneatanycost;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GameOfThronesApp {
    public static void main(String[] args) {
        Map<String, Integer> initialRoles = new HashMap<>();
        initialRoles.put("Lord", 1);
        initialRoles.put("Knight", 2);
        initialRoles.put("Mage", 1);

        House houseStark = new House("Stark", initialRoles);

        User user1 = new User("Arya");
        User user2 = new User("Jon");
        User user3 = new User("Sansa");
        User user4 = new User("Bran");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        user1.setHouse(houseStark);
        user1.setChosenRole("Lord");

        user2.setHouse(houseStark);
        user2.setChosenRole("Knight");

        user3.setHouse(houseStark);
        user3.setChosenRole("Knight");

        user4.setHouse(houseStark);
        user4.setChosenRole("Mage");

        executor.submit(user1);
        executor.submit(user2);
        executor.submit(user3);
        executor.submit(user4);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

