package faang.school.godbless.MiceAreVeryNice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        Room kitchen = new Room("Kitchen");
        kitchen.addFood(new Food("Apple"));
        kitchen.addFood(new Food("Water"));

        Room livingRoom = new Room("Living room");
        livingRoom.addFood(new Food("Pizza"));
        livingRoom.addFood(new Food("Cheese"));

        Room bedroom = new Room("Bedroom");
        bedroom.addFood(new Food("Coffee"));
        bedroom.addFood(new Food("Banana"));

        Room garage = new Room("Garage");
        garage.addFood(new Food("Beer 1"));
        garage.addFood(new Food("Beer 2"));

        house.addRoom(kitchen);
        house.addRoom(livingRoom);
        house.addRoom(bedroom);
        house.addRoom(garage);

        int threadPoolSize = 2;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            executor.schedule(house::collectFood, i * 30, TimeUnit.SECONDS);
        }

        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("All threads completed.");
            System.out.println("Food is collected: " + house.getCollectedFood());
        }, threadPoolSize * 30, TimeUnit.SECONDS);

    }
}