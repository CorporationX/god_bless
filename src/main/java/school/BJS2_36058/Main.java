package school.BJS2_36058;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int SCHEDULED_THREADS = 5;

        House house = new House();
        house.initialize();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(SCHEDULED_THREADS);
        executorService.scheduleAtFixedRate(() -> house.collectFood(), 0, 30, TimeUnit.SECONDS);

        while(true) {
            if (house.isAll()) {
                System.out.println("Еда собрана из всех комнат!");
                executorService.shutdown();
                break;
            }
        }


    }


}

