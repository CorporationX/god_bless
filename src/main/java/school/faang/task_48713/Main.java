package school.faang.task_48713;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    static final int CORE_POOL_SIZE = 5;
    static final int INITIAL_DELAY = 0;
    static final int PERIOD = 30;

    public static void main(String[] args) {
        House house = new House();

        CountDownLatch latch = new CountDownLatch(house.getRooms().size());
        house.setLatch(latch);

        Runnable collector = () -> {
            house.collectFood();
        };

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(CORE_POOL_SIZE);
        for (int i = 0; i < CORE_POOL_SIZE; i++) {
            executor.scheduleAtFixedRate(collector, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error("Waiting for tasks to complete was interrupted: ", e);
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
    }
}
