package faang.school.godbless.sprint.three.mice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String... args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

        house.getRooms().forEach(room -> scheduler.scheduleAtFixedRate(() -> {
                if (house.noFoodInRooms() && !scheduler.isShutdown()) {
                    System.out.println("There is no food in rooms, scheduler will be shutdown!");
                    scheduler.shutdown();
                }
                house.collectFood();
            }, Constants.SCHEDULER_DELAY, Constants.SCHEDULER_PERIOD, TimeUnit.SECONDS)
        );

        try {
            if (!scheduler.awaitTermination(Constants.SCHEDULER_TIMEOUT, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }

        System.out.println("Food in house:");
        house.getFoods().forEach(food -> System.out.printf("%s, ", food.getName()));
    }
}
