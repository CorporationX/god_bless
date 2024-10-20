package faang.school.godbless.mt.mice;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_POOL_SIZE = 5;
    private static final int TIMEOUT_IN_SECONDS = 180;
    private static final int TASK_PERIOD_IN_SECONDS = 30;

    public static void main(String[] args) {
        House house = new House(List.of(
                new Room(List.of(new Food("apple"), new Food("pineapple"), new Food("banana"))),
                new Room(List.of(new Food("chocolate"), new Food("ice"))),
                new Room(List.of(new Food("icecream"))),
                new Room(List.of(new Food("cherry"))),
                new Room(List.of(new Food("cucumber"))),
                new Room(List.of(new Food("tomato"))),
                new Room(List.of(new Food("banana2")))
        )

        );
        collectFood(house, TIMEOUT_IN_SECONDS);
    }

    public static void collectFood(House house, int collectingTimeInSeconds) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREADS_POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, 0, TASK_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

        try {
            executor.awaitTermination(collectingTimeInSeconds, TimeUnit.SECONDS);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        if (house.roomsContainsFood()) {
            log.warn("No all food is collected");
        }
        log.info("Collected food: {}", house.getTakenFoods());
    }
}
