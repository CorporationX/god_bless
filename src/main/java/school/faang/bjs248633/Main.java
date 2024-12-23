package school.faang.bjs248633;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();

        Room kitchen = new Room("Kitchen");
        kitchen.addFood(new Food("Cheese"));
        kitchen.addFood(new Food("Milk"));
        kitchen.addFood(new Food("Eggs"));
        kitchen.addFood(new Food("Butter"));

        Room livingRoom = new Room("Living Room");
        livingRoom.addFood(new Food("Chips"));
        livingRoom.addFood(new Food("Soda"));
        livingRoom.addFood(new Food("Popcorn"));
        livingRoom.addFood(new Food("Chocolate"));

        Room bedroom = new Room("Bedroom");
        bedroom.addFood(new Food("Candy"));
        bedroom.addFood(new Food("Cookies"));
        bedroom.addFood(new Food("Gum"));

        Room basement = new Room("Basement");
        basement.addFood(new Food("Juice"));
        basement.addFood(new Food("Cereal"));
        basement.addFood(new Food("Granola Bars"));

        Room attic = new Room("Attic");
        attic.addFood(new Food("Peanut Butter"));
        attic.addFood(new Food("Jelly"));
        attic.addFood(new Food("Crackers"));

        house.addRoom(kitchen);
        house.addRoom(livingRoom);
        house.addRoom(bedroom);
        house.addRoom(basement);
        house.addRoom(attic);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        log.info("ScheduledExecutorService created with 5 threads.");

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            scheduledExecutorService.scheduleAtFixedRate(
                    house::collectFood,
                    0,
                    30,
                    TimeUnit.SECONDS
            );
        }
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            log.error("Main thread interrupted while sleeping.", e);
            Thread.currentThread().interrupt();
        }

        scheduledExecutorService.shutdown();
        log.info("Shutdown initiated for scheduler. Waiting for tasks to complete...");

        try {
            if (scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.info("All scheduled tasks finished. House food collection ended.");
            } else {
                log.warn("Some tasks did not complete within 60 seconds. Forcing shutdown now...");
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted while awaiting scheduler termination.", e);
            Thread.currentThread().interrupt();
        }

        log.info("Process complete. Check logs for collected food details.");
        System.out.println("All done! Food collection with scheduleAtFixedRate finished.");
    }
}
