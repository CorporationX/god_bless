package school.faang.MiceAre9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = getHouse();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        service.scheduleAtFixedRate(() -> {
            house.collectFood();
            System.out.println("Totally collected: " + house.getCollectedFood());
        }, 0, 30, TimeUnit.SECONDS);

        if (house.allFoodCollected()) {
            service.shutdown();
            System.out.println("All foods collected!");
        }
    }

    private static House getHouse() {
        List<Food> foods1 = new ArrayList<>(List.of(new Food("Banana"), new Food("Grape"), new Food("Pineapple")));
        List<Food> foods2 = new ArrayList<>(List.of(new Food("Soup"), new Food("Pasta")));
        List<Food> foods3 = new ArrayList<>(List.of(new Food("Apple"), new Food("Fresh")));

        Room room1 = new Room("Room 1", foods1);
        Room room2 = new Room("Room 2", foods2);
        Room room3 = new Room("Room 3", foods3);


        House house = new House(new ArrayList<>(List.of(room1, room2, room3)));
        return house;
    }
}
