package school.faang.sprint3.bjs_48206;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int ROOMS_IN_HOUSE = 5;
        final int THREADS = 5;
        final int DELAY = 1;
        final int PERIOD = 1;

        House house = new House(ROOMS_IN_HOUSE);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREADS);
        executorService.scheduleAtFixedRate(house::collectFood, DELAY, PERIOD, TimeUnit.SECONDS);

        log.info("Cleaning started...");
        try {
            while (!house.allFoodCollected()) {
                Thread.sleep(1000);
            }
            log.info("All food collected");
            executorService.shutdown();
        } catch (InterruptedException e) {
            log.warn("Something went wrong - threads forced to stop");
            executorService.shutdownNow();
        }
    }
}
