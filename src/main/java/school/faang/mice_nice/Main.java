package school.faang.mice_nice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Initialization initialization = new Initialization();
        House hotel = initialization.createHouse();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(DataSet.THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            hotel.collectFood();
            if (hotel.hasAllFoodCollected()) {
                executor.shutdown();
                log.info("All rooms served");
                System.out.println(hotel.getCollectedFood());
            }
        }, DataSet.THREAD_INITIAL_DELAY, DataSet.THREAD_TIMEOUT, TimeUnit.SECONDS);
    }
}
