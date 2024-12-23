package school.faang.task_48403;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int PERIOD = 30;

    public static void main(String[] args) {
        House house = new House(initializeRooms());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executorService.scheduleAtFixedRate(house::collectFood, 0, PERIOD, TimeUnit.SECONDS);

        while (true) {
            if (house.allCollectedFood()) {
                executorService.shutdown();
                log.info("All foods collected");
                break;
            }
        }
    }

    private static List<Room> initializeRooms() {
        List<Room> initialRooms = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            initialRooms.add(new Room(i));
        }
        return initialRooms;
    }
}
