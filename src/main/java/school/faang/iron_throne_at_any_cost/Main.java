package school.faang.iron_throne_at_any_cost;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int THREAD_POOL_SIZE = 7;
        House firstHouse = new House("Lvenok");
        House secondHouse = new House("Girafik");
        House thirdHouse = new House("Kotenok");

        List<House> houses = new ArrayList<>();
        houses.add(firstHouse);
        houses.add(secondHouse);
        houses.add(thirdHouse);

        firstHouse.addRole(Role.LORD, Role.KNIGHT, Role.MAGE);
        secondHouse.addRole(Role.LORD, Role.KNIGHT, Role.MAGE);
        thirdHouse.addRole(Role.LORD, Role.KNIGHT, Role.MAGE);

        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 1; i < 50; i++) {
            String userName = "user " + i;
            House assignedHouse = houses.get(random.nextInt(houses.size()));
            User user = new User(userName, assignedHouse);

            executor.submit(() -> {
                try {
                    user.joinHouse(assignedHouse);
                    Thread.sleep(random.nextInt(10000));
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException("Thread has been interrupted " + e.getMessage());
                }
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread has been interrupted " + e.getMessage(), e);
        }
    }
}