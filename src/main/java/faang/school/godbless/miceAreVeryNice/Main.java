package faang.school.godbless.miceAreVeryNice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        House house = new House();
        Room room1 = new Room();
        room1.addFood(new Food("Apple"));
        room1.addFood(new Food("Banana"));
        house.addRoom(room1);
        Room room2 = new Room();
        room2.addFood(new Food("Bread"));
        room2.addFood(new Food("Cheese"));
        house.addRoom(room2);
        Room room3 = new Room();
        room3.addFood(new Food("Milk"));
        room3.addFood(new Food("Meat"));
        house.addRoom(room3);
        Room room4 = new Room();
        room4.addFood(new Food("Chocolate"));
        room4.addFood(new Food("Meat"));
        house.addRoom(room4);
        Room room5 = new Room();
        room5.addFood(new Food("Salad"));
        room5.addFood(new Food("Coffee"));
        house.addRoom(room5);

        int roomIndexToStart = 0;
        for (int i = 0; i < 5; i++) {
            int startIndex = roomIndexToStart;
            if (roomIndexToStart < house.getRooms().size() - 1) {
                executor.schedule(() ->
                        house.collectFood(startIndex), 5, TimeUnit.SECONDS);
                roomIndexToStart += 2;
            }
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Collected from all rooms.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
