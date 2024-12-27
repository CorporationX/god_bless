package school.faang.sprint3.task_48467;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static school.faang.sprint3.task_48467.HouseSettings.THREAD_COUNT;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_COUNT);

        IntStream.range(0, THREAD_COUNT).forEach((i) ->
                executorService.scheduleAtFixedRate(house::collectFood, 0, 5, TimeUnit.SECONDS)
        );

        ScheduledExecutorService checker = Executors.newSingleThreadScheduledExecutor();
        checker.scheduleAtFixedRate(() -> {
            if (house.allFoodIsCollected()) {
                System.out.println("All food is collected. Shutting down");
                executorService.shutdown();
                checker.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);

        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
            checker.awaitTermination(30, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
            checker.shutdownNow();
        }

        house.printAllCollectedFood();
    }
}
