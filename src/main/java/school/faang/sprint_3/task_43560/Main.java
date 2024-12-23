package school.faang.sprint_3.task_43560;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 5;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        List<House> houses = new ArrayList<>(List.of(
                new House("Bronn"), new House("Greyjoy"),
                new House("Baratheon"), new House("Lannister")
        ));

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            User user = new User("User " + (i + 1));
            executor.execute(() -> user.joinHouse(houses.get(new Random().nextInt(houses.size()))));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи были завершены.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
