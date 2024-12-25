package school.faang.sprint_3.task_48487;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        System.out.println("Initial state of the house:");
        System.out.println(house);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Runnable task = () -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executor.shutdown();
                System.out.println("Еда в доме собрана!");
            }
        };

        executor.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);


        try {
            executor.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final state of the house:");
        System.out.println(house);
    }
}
