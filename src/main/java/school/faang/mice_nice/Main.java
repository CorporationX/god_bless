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
        hotel.preparedRoomsToTidy();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(DataSet.THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            if (hotel.collectFood()) {
                executor.shutdown();
            }
        }, DataSet.THREAD_INITIAL_DELAY, DataSet.THREAD_TIMEOUT, TimeUnit.SECONDS);

        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Amount of food collected from rooms {}", hotel.getCollectedFood().size());
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Tasks completed with errors {}", e.getMessage());
        }
    }
}
