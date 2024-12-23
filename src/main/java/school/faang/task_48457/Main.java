package school.faang.task_48457;

import lombok.extern.slf4j.Slf4j;

import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 5;
    private static final int INIT_DELAY = 0;
    private static final int PERIOD = 30;

    public static void main(String[] args) {
        House house = new House();
        FoodCollector collector = new FoodCollector(house);
        CountDownLatch countDownLatch = new CountDownLatch(house.getRoomCount());
        house.setCdl(countDownLatch);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        executor.scheduleAtFixedRate(collector, INIT_DELAY, PERIOD, TimeUnit.SECONDS);

        try {
            countDownLatch.await();
            executor.shutdown();
            log.info("Вся еда собрана!");
        } catch (InterruptedException e) {
            log.error("Ошибка при выполнении метода await()", e);
            executor.shutdownNow();
        }
    }
}
