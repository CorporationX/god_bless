package school.faang.BJS236005;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threadPool = 3;
        House house = new House();
        house.init();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(threadPool);
        service.scheduleAtFixedRate(house::collectFood, 0, 4, TimeUnit.SECONDS);
        service.schedule(() -> {
            service.shutdown();
            System.out.println("Общая еда: " + house.getCollectedFood());
        }, 1, TimeUnit.MINUTES);
    }
}
