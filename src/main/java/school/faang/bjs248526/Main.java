package school.faang.bjs248526;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.initialize();
        System.out.println("House setup : " + house.getRoomsList());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(Constants.THREADS);
        executor.scheduleAtFixedRate(house::collectFood, 0, 200, TimeUnit.MILLISECONDS);

        ScheduledExecutorService checker = Executors.newSingleThreadScheduledExecutor();
        checker.scheduleAtFixedRate(() -> {
            if (house.allFoodCollected()) {
                executor.shutdown();
                checker.shutdown();
                System.out.println("No more food to collect.");
                System.out.println("Food collection at home completed! : " + house.getCollectedFood());
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
