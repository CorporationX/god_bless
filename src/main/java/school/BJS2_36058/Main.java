package school.BJS2_36058;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int SCHEDULED_THREADS = 5;

        CountDownLatch latch = new CountDownLatch(SCHEDULED_THREADS);
        House house = new House();
        house.initialize();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(SCHEDULED_THREADS);
        for (int i = 0; i < SCHEDULED_THREADS; i++) {
            executorService.scheduleAtFixedRate(new HouseThread(house, latch), 0, 30, TimeUnit.SECONDS);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (house.isAll()) {
            System.out.println("Еда собрана из всех комнат!");
            executorService.shutdown();
        }
    }
}

