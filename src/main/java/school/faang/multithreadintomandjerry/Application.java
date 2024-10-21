package school.faang.multithreadintomandjerry;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Application {
    private static final int THREAD_QUANTITY = 5;
    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 5;

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(House.QUANTITY_ROOMS);
        House house = new House(cdl);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_QUANTITY);
        for (int i = 0; i < THREAD_QUANTITY; i++) {
            scheduler.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println("cdl.await() crashed");
            e.printStackTrace();
        }
        scheduler.shutdown();

        log.info("Foods count: {}, all foods: {} ", house.getCollectedFoods().size(), house.getCollectedFoods());
    }
}
