package school.faang.tomandjerry;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static school.faang.tomandjerry.House.CORE_POOL_SIZE;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = new House(House.initialization());
        System.out.println("Count of rooms in the house: " + house.getRooms().size());
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        house.assigningTasksToThreads(scheduler, house);
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Tasks not completed in 5 minutes, forced to disconnect");
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            log.error("Caught exception: ", e);
        }
        System.out.println("All the food is collected!");
        System.out.println("Collected food: " + house.getCollectedFood());
    }
}

