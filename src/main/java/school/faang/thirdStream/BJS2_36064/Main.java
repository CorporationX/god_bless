package school.faang.thirdStream.BJS2_36064;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int SERVANTS_COUNT = 2;
    private static final int DELAY = 1;
    private static final int FREQUENCY = 10;

    public static void main(String[] args) {
        House house = new House();
        CountDownLatch countDownLatch = new CountDownLatch(house.getRooms().size());
        house.setCountDownLatch(countDownLatch);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(SERVANTS_COUNT);

        for (int i = 0; i < SERVANTS_COUNT; i++) {
            executor.scheduleAtFixedRate(new Servant(house), DELAY, FREQUENCY, TimeUnit.SECONDS);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("проблема с методом await: {}", String.valueOf(e));
        }

        executor.shutdown();

        System.out.println("Работа окончена");
    }
}
