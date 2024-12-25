package school.faang.bjs248526;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        initData(house);
        System.out.println("House setup : " + house.getRoomsList());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(Constants.THREADS);

        executor.scheduleAtFixedRate(() -> house.collectFood(executor), 0, 3, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
            System.out.println("Food collection at home completed! : " + house.getCollectedFood());
        }));
    }

    private static void initData(House house) {
        Random random = new Random();

        house.getRoomsList().addAll(
                random.ints(1,10)
                        .limit(random.nextInt(10))
                        .mapToObj(roomNo -> new Room("Room no: " + roomNo,
                                (random.ints(0,5)
                                    .limit(5))
                                    .mapToObj(foodNo -> new Food("Food no: " + foodNo + " for room no: " + roomNo))
                                    .toList()))
                        .toList()
                );
    }
}
