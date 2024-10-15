package school.faang.micenice;

import java.util.concurrent.*;

public class Main {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        while (!house.allFoodCollected()) {
            executor.scheduleAtFixedRate(house::collectFood, 0, 5, TimeUnit.SECONDS);
        }
        executor.shutdown();
        System.out.println("The food is collected");
    }
}
