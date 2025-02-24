package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int NUMBER_OF_ROOMS = 20;
    private static final int COLLECT_INTERVAL = 10;
    private static final int TIMEOUT_SECONDS = 5;
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_ROOMS; ++i) {
            List<Food> foodList = new ArrayList<>();
            for (int j = 1; j <= 4; ++j) {
                foodList.add(new Food("Food " + i * j, random.nextInt(50)));
            }
            rooms.add(new Room(foodList));
        }
        CountDownLatch latch = new CountDownLatch(1);
        House house = new House(rooms);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; ++i) {
            executor.scheduleAtFixedRate(() -> {
                house.collectFood();
                if (house.isAllFoodCollected()) {
                    latch.countDown();
                }
            }, 0, COLLECT_INTERVAL, TimeUnit.SECONDS);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error("Main thread interrupted while waiting.");
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Not all tasks have been completed on time.");
                executor.shutdownNow();
            } else {
                log.info("All food was collected.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("awaitTermination was interrupted.");
            throw new RuntimeException(e);
        }
    }
}
