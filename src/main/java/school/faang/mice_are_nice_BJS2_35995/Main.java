package school.faang.mice_are_nice_BJS2_35995;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_THREADS = 5;
    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 1;

    public static void main(String[] args) throws InterruptedException {
        List<Room> rooms = new ArrayList<>();

        Room livingRoom = new Room(new ArrayList<>());
        livingRoom.addFood(new Food("Apple"));
        livingRoom.addFood(new Food("Banana"));
        livingRoom.addFood(new Food("Pizza"));

        Room kitchen = new Room(new ArrayList<>());
        kitchen.addFood(new Food("Donut"));
        kitchen.addFood(new Food("Chocolate"));
        kitchen.addFood(new Food("Ice Cream"));

        Room pantry = new Room(new ArrayList<>());
        pantry.addFood(new Food("Sushi"));
        pantry.addFood(new Food("Pasta"));
        pantry.addFood(new Food("Burger"));
        pantry.addFood(new Food("Salad"));

        House house = new House(rooms, new ArrayList<>());
        rooms.add(livingRoom);
        rooms.add(kitchen);
        rooms.add(pantry);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(COUNT_THREADS);
        executorService.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

        while (!house.isFoodCollected()) {
            Thread.sleep(1000);
        }
        executorService.shutdown();

        System.out.println("All food collected");
        System.out.println(house.getCollectedFood());
    }
}
