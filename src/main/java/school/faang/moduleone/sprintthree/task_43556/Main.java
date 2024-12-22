package school.faang.moduleone.sprintthree.task_43556;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    static final int COLLECTORS_COUNT = 5;
    static final int DELAY = 0;
    static final int PERIOD = 5;
    static final int ROOMS_COUNT = 20;

    public static void main(String[] args) {
        House house = new House(ROOMS_COUNT);
        CountDownLatch cdl = new CountDownLatch(ROOMS_COUNT);
        house.setCountDownLatch(cdl);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(COLLECTORS_COUNT);

        for (int i = 0; i < 5; i++) {
            executor.scheduleAtFixedRate(new FoodCollector(house), DELAY, PERIOD, TimeUnit.SECONDS);
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            log.error("Some error with await: {}", e.getMessage());
        }
        executor.shutdown();
        log.info("Вся еда собрана. Завершаем работу.");
    }
}
