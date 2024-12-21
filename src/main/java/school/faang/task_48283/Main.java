package school.faang.task_48283;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_THREAD = 5;
    private static final long PERIOD = 30;

    public static void main(String[] args) {
        House house = addHouseData();
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(MAX_THREAD);
        executor.scheduleAtFixedRate(house::collectFood, 0, PERIOD, TimeUnit.SECONDS);
        while (true) {
            if (house.checkAllFoodCollected()) {
                executor.shutdown();
                System.out.println("All food was collected");
                System.out.println(house.toString());
                break;
            }
        }
    }

    private static House addHouseData() {
        List<Room> rooms = new ArrayList<>();
        List<Food> kitchenFood = new ArrayList<>(Arrays.asList(new Food("Banana"), new Food("Bred")));
        List<Food> bedroomFood = new ArrayList<>(Arrays.asList(new Food("Vine"), new Food("Apple")));
        List<Food> childRoom = new ArrayList<>(Arrays.asList(new Food("Candy"), new Food("Chips"),
                new Food("Chocolate")));
        rooms.add(new Room("Kitchen", kitchenFood));
        rooms.add(new Room("Bedroom", bedroomFood));
        rooms.add(new Room("Child room", childRoom));
        return new House(rooms);
    }
}
