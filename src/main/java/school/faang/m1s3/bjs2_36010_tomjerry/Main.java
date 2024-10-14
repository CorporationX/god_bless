package school.faang.m1s3.bjs2_36010_tomjerry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House(Arrays.asList(
                new Room("Kitchen", new ArrayList<>(Arrays.asList(
                        new Food("Cheese"), new Food("Meat"), new Food("Fish")))),
                new Room("Guestroom", new ArrayList<>(Arrays.asList(
                        new Food("Cheese"), new Food("Candy"), new Food("Fish")))),
                new Room("Bathroom", new ArrayList<>(Arrays.asList(
                        new Food("Fish")))),
                new Room("Bedroom", new ArrayList<>(Arrays.asList(
                        new Food("Candy"), new Food("Meat"), new Food("Chips"))))
        ));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        service.scheduleAtFixedRate(() -> {
            if (house.getRooms().stream().allMatch(r -> r.getFood().isEmpty())) {
                service.shutdown();
                System.out.println("All food gathered");
            } else {
                house.collectFood();
            }
        }, 0, 10, TimeUnit.SECONDS);

        try {
            if (!service.awaitTermination(10, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
