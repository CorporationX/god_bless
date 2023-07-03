package sprint4.mice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREAD = 5;
    public static void main(String[] args) {
        House house = new House();
        house.initRooms();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(NUM_THREAD);
        for (int i = 0; i < NUM_THREAD; i++) {
            service.schedule(house::collectFood, 5, TimeUnit.SECONDS);
        }
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All the food is packed");
        System.out.println(house.getCollectedFood());
    }
}
