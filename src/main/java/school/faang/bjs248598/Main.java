package school.faang.bjs248598;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int COUNT_COLLECTORS = 5;
    static final int DELAY = 0;
    static final int PERIOD = 10;
    static final long WORK_TIME = 7;

    public static void main(String[] args) {
        House house = new House();
        CountDownLatch countDownLatch = new CountDownLatch(house.notCleanedUpRoom());
        house.setCountDownLatch(countDownLatch);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_COLLECTORS);
        for (int i = 0; i <= COUNT_COLLECTORS; i++) {
            executor.scheduleAtFixedRate(new CollectorFood(house), DELAY, PERIOD, TimeUnit.SECONDS);
        }
        try {
            if (!countDownLatch.await(WORK_TIME, TimeUnit.SECONDS)) {
                System.out.println("Execution time tasks expired");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            e.getMessage();
        }
        executor.shutdown();
        System.out.println("All the food in the house has been collected");
    }
}
