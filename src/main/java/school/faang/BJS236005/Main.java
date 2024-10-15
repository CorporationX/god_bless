package school.faang.BJS236005;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    final static int THREAD_POOL = 5;

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.init();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(THREAD_POOL);
        service.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        if (!service.awaitTermination(5, TimeUnit.MINUTES)) {
            service.shutdown();
            System.out.println("Общая еда: " + house.getCollectedFood());
        }
    }
}
