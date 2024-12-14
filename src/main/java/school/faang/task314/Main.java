package school.faang.task314;

import school.faang.task314.house.House;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBET_OF_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.initialize();

        ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(NUMBET_OF_THREAD);

        for (int i = 0; i < NUMBET_OF_THREAD; i++) {
            scheduledPool.scheduleWithFixedDelay(house::collectFood, 0, 1, TimeUnit.SECONDS);
        }

        try {
            if (!scheduledPool.awaitTermination(2, TimeUnit.MINUTES)) {
                scheduledPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }

        scheduledPool.shutdown();
        System.out.println("Еда в доме собрана!");
    }
}
