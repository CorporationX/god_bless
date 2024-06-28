package faang.school.godbless.sprint3.miceAreVeryNice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int CORE_POOL_SIZE = 5;

    public static void main(String[] args) {
        Room room1 = new Room(Arrays.asList(new Food("food1"), new Food("food2")));
        Room room2 = new Room(Arrays.asList(new Food("food3"), new Food("food4"), new Food("food5")));


        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(CORE_POOL_SIZE);
        House house = new House(List.of(room1, room2), new ArrayList<>());


        for (int i = 1; i <= CORE_POOL_SIZE; i++) {
            executorService.schedule(house::collectFood, 2L * i, TimeUnit.SECONDS);
        }

        executorService.shutdown();


        try {
            if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Executor is completed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
