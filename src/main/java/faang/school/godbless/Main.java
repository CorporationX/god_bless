package faang.school.godbless;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Room room1 = new Room(List.of(new Food("Apple"), new Food("Banana")));
        Room room2 = new Room(List.of(new Food("Bread"), new Food("Milk")));
        Room room3 = new Room(List.of(new Food("Cheese"), new Food("Eggs")));
        Room room4 = new Room(List.of(new Food("Yogurt"), new Food("Orange")));
        Room room5 = new Room(List.of(new Food("Cucumber"), new Food("Tomato")));

        List<Room> rooms = List.of(room1, room2, room3, room4, room5);
        House house = new House(rooms);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.schedule(() -> house.collectFood(), i * 5, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (house.isFoodCollected()) {
            System.out.println("Еда в доме собрана!");
        }
    }
}
