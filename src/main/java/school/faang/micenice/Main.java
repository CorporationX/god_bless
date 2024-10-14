package school.faang.micenice;

import java.util.concurrent.*;

public class Main {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executor.shutdown();
                System.out.println("All the food is collected.");
            }
        }, 0, 3, TimeUnit.SECONDS);
    }
}
