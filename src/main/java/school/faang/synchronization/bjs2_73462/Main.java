package school.faang.synchronization.bjs2_73462;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static school.faang.synchronization.bjs2_73462.TestData.ROOMS_WITH_FOOD;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        Collections.shuffle(ROOMS_WITH_FOOD);
        BlockingDeque<Room> randomRooms = new LinkedBlockingDeque<>(ROOMS_WITH_FOOD);
        House house = new House(ROOMS_WITH_FOOD);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        house.printRooms();

        for (int counter = 0; counter < THREAD_POOL_SIZE; counter++) {
            executorService.scheduleAtFixedRate(() -> {
                house.collectFood(randomRooms);
                if (house.allFoodCollected()) {
                    executorService.shutdown();
                }
            }, 0, 30, TimeUnit.SECONDS);
        }

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Произошла ошибка!");
            executorService.shutdownNow();
        }

        log.info("Еда в доме собрана!");
        house.printRooms();
        log.info("collected food:\n");
        house.printCollectedFood();
    }
}
