package school.faang.task_48354;

import java.util.concurrent.*;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Runnable task = () -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executor.shutdown();
                System.out.println("Food in the house is collected!");
                System.out.println("General collected food: " + house.getCollectedFood());
            }
        };

        executor.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);

        try {
            boolean terminated = executor.awaitTermination(5, TimeUnit.MINUTES);
            if (terminated) {
                System.out.println("All threads have completed their work.");
            } else {
                System.err.println("Timed out waiting for threads to complete.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error while waiting for threads to complete.");
        }
    }
}