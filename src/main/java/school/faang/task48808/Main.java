package school.faang.task48808;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    static final int COUNT_OFFICIANT = 3;
    static final int DELAY = 0;

    static final int FREQUENCY = 10;

    public static void main(String[] args) {

        House house = new House();
        CountDownLatch cdl = new CountDownLatch(house.sizeRoom());

        house.setCdl(cdl);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_OFFICIANT);
        for (int i = 0; i < COUNT_OFFICIANT; i++) {
            executor.scheduleAtFixedRate(new Officiant(house), DELAY, FREQUENCY, TimeUnit.SECONDS);
        }


        try {
            cdl.await();
        } catch (InterruptedException e) {
            log.error(" какая то проблема с методом await {} ", String.valueOf(e));
        }
        executor.shutdown();
        log.info("Work is done .");

    }

}
