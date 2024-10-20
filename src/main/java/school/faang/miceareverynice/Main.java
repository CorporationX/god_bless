package school.faang.miceareverynice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.addRoom(new Room("Kitchen", List.of(new Food("Apple"), new Food("Bread"))));
        house.addRoom(new Room("Living Room", List.of(new Food("Cheese"), new Food("Wine"))));
        house.addRoom(new Room("Bedroom", List.of(new Food("Cookies"), new Food("Milk"))));
        house.addRoom(new Room("Attic", List.of(new Food("Jam"), new Food("Peanut Butter"))));
        house.addRoom(new Room("Dining Room", List.of(new Food("Cake"), new Food("Juice"))));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        }

        executorService.schedule(() -> {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
                System.out.println("All food has been collected in the house!");
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }, 2, TimeUnit.MINUTES);
    }
}
