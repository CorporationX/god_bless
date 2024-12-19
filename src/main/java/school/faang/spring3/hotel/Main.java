package school.faang.spring3.hotel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    static final int OFFICIANT_COUNT = 5;
    static final int DELAY = 0;
    static final int FREQUENCY = 3;

    public static void main(String[] args) {
        House house = new House();
        CountDownLatch countDownLatch = new CountDownLatch(house.getRoomSize());
        house.setCdl(countDownLatch);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(OFFICIANT_COUNT);
        for (int i = 0; i < 3; i++) {
            executor.scheduleAtFixedRate(new Officiant(house), DELAY, FREQUENCY, TimeUnit.SECONDS);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("problem with method await");
        }

        executor.shutdown();
        System.out.println("All food collected");


    }
}
