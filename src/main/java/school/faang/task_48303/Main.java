package school.faang.task_48303;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    static final int COUNT_OFFICIANT = 5;
    static final int DELAY = 10;
    static final int FREQUENCY = 10;

    public static void main(String[] args) {
        House house = new House();
        CountDownLatch cdl = new CountDownLatch(house.sizeRooms());
        house.setCdl(cdl);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_OFFICIANT);

        for (int i = 0; i < COUNT_OFFICIANT; i++) {
            executor.scheduleAtFixedRate(() -> new Officiant(house).start(), DELAY, FREQUENCY, TimeUnit.SECONDS);
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            log.error("await проблема ", e);
        }

        executor.shutdown();
        System.out.println("Работа закончена");

        List<Food> collected = house.getCollectedFood();
        collected.forEach(System.out::println);
    }
}