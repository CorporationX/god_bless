package school.faang.task_48922;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int THREAD_POOL_SIZE = 5;
    static final int DELAY = 0;
    static final int FREQUENCY = 30;

    public static void main(String[] args) {

        House house = new House();
        house.initialize();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        executorService.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
                System.out.println("The food in the house is collected!");
                System.out.println("Collected food: " + house.getCollectedFood());
            }
        }, DELAY, FREQUENCY, TimeUnit.SECONDS);
    }
}

