package school.faang.BJS236035;

import lombok.extern.slf4j.Slf4j;
import school.faang.BJS236035.dto.House;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Main {
    public static final int COUNT_ROOMS = 10;
    public static final int COUNT_TREAD_POOL = 5;
    public static final int DELAY = 0;
    public static final int PERIOD = 30;

    public static void main(String[] args) {
        House house = new House(COUNT_ROOMS);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(COUNT_TREAD_POOL);
        executorService.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
                log.info("«Еда в доме собрана!»");
            }
        }, DELAY, PERIOD, SECONDS);
    }
}
