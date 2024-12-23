package school.faang.bjs248598;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int COUNT_COLLECTORS = 5;
    static final int DELAY = 0;
    static final int PERIOD = 5;

    public static void main(String[] args) {
        House house = new House();
        CountDownLatch countDownLatch = new CountDownLatch(house.roomSize());
        house.setCountDownLatch(countDownLatch);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_COLLECTORS);
        for (int i = 0; i <= COUNT_COLLECTORS; i++) {
            executor.scheduleAtFixedRate(new CollectorFood(house), DELAY, PERIOD, TimeUnit.SECONDS);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("All the food in the house has been collected");
    }
}
