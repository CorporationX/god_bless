package school.faang.mice_are_very_nice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int FOOD_COLLECTORS_COUNT = 5;
    private static final int DELAY = 0;
    private static final int PERIOD = 30;

    public static void main(String[] args) {
        House house = new House();
        CountDownLatch cdl = new CountDownLatch(house.sizeRooms());
        house.setCdl(cdl);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(FOOD_COLLECTORS_COUNT);
        for (int i = 0; i < FOOD_COLLECTORS_COUNT; i++) {
            executor.scheduleAtFixedRate(new FoodCollector(house), DELAY, PERIOD, TimeUnit.SECONDS);
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            log.error("There is a problem with a thread, connected to await method: " + e);
        }
        executor.shutdown();
        System.out.println("All food in the house has been collected");
    }
}