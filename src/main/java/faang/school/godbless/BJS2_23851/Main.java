package faang.school.godbless.BJS2_23851;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 5;
    public static final int DELAY = 30;

    public static void main(String[] args) throws InterruptedException {
        List<Food> kitchenFood = new ArrayList<>();
        kitchenFood.add(new Food("apple"));
        kitchenFood.add(new Food("milk"));
        kitchenFood.add(new Food("bread"));
        kitchenFood.add(new Food("orange"));
        List<Food> livingRoomFood = new ArrayList<>();
        livingRoomFood.add(new Food("pizza"));
        livingRoomFood.add(new Food("salad"));
        List<Food> bedRoomFood = new ArrayList<>();
        bedRoomFood.add(new Food("cake"));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(kitchenFood));
        rooms.add(new Room(livingRoomFood));
        rooms.add(new Room(bedRoomFood));
        House house = new House(rooms);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUM_THREADS);
        for (int i = 0; i < house.getRooms().size(); i += 2) {
            List<Room> currentRooms = house.getRooms().stream()
                    .skip(i)
                    .limit(2)
                    .toList();
            executor.schedule(() -> house.collectFood(currentRooms), DELAY, TimeUnit.SECONDS);
        }
        executor.shutdown();
        while(!executor.awaitTermination(10, TimeUnit.SECONDS)) {}
        System.out.println("Food was collected from all rooms");
    }
}
