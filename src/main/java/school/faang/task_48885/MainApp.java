package school.faang.task_48885;

import school.faang.task_48885.entity.Food;
import school.faang.task_48885.entity.House;
import school.faang.task_48885.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) {
        Room kitchen = new Room();
        kitchen.addFood(new Food("Apple"));
        kitchen.addFood(new Food("Banana"));
        Room livingRoom = new Room();
        livingRoom.addFood(new Food("Sandwich"));
        livingRoom.addFood(new Food("Juice"));
        Room bedroom = new Room();
        bedroom.addFood(new Food("Chocolate"));
        bedroom.addFood(new Food("Cookies"));

        List<Room> rooms = new ArrayList<>();
        rooms.add(kitchen);
        rooms.add(livingRoom);
        rooms.add(bedroom);

        House house = new House();
        System.out.println("Before food collected:");
        System.out.println(rooms);
        Runnable task = (() -> house.collectFood(rooms));
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        IntStream.range(0, 5).forEach(i ->
                scheduler.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS)
        );
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scheduler.shutdown();
        try {
            if (scheduler.awaitTermination(15, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nAfter food collected:");
        System.out.println(rooms);
        System.out.println("All food collected:");
        System.out.println(house.getCollectedFood());
        System.out.println("All food collected");
    }
}