package school.faang.sprint3.bjs_48206;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int roomsInHouse = 9;
        int numbersOfThreads = 5;
        int delayOnStart = 1;
        int timeOut = 1;
        int waitingMsec = 1000;

        House house = new House(roomsInHouse);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(numbersOfThreads);
        executorService.scheduleAtFixedRate(house::collectFood, delayOnStart, timeOut, TimeUnit.SECONDS);

        log.info("Cleaning started...");
        try {
            while (!house.allFoodCollected()) {
                Thread.sleep(waitingMsec);
            }
            log.info("All food collected");
            executorService.shutdown();
        } catch (InterruptedException e) {
            log.warn("Something went wrong - threads forced to stop");
            executorService.shutdownNow();
        }
    }
}
