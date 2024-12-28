package school.faang.task_48716;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int COUNT_OFFICIANT = 5;
    static final int DELAY = 0;
    static final int FREQUENCY_OFFICIANT = 5;

    public static void main(String[] args) {
        House house = new House();
        CountDownLatch countDownLatch = new CountDownLatch(house.sizeRooms());
        house.setCdl(countDownLatch);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_OFFICIANT);
        for (int i = 0; i < COUNT_OFFICIANT; i++) {
            executor.scheduleAtFixedRate(new Officiant(house), DELAY, FREQUENCY_OFFICIANT, TimeUnit.SECONDS);
        }


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        System.out.println("Работа на сегодня закончена");
    }
}
