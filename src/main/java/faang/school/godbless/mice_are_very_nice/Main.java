package faang.school.godbless.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        List<Food> fruits = List.of(new Food("apple"), new Food("banana"), new Food("pineapple"));
        List<Food> vegetables = List.of(new Food("potato"), new Food("tomato"), new Food("carrot"));
        List<Food> fastFood = List.of(new Food("burger"), new Food("pizza"), new Food("taco"));
        List<Food> randomFood = List.of(new Food("eggs"), new Food("lollipops"), new Food("chips"));
        List<Food> drink = List.of(new Food("coffee"), new Food("tea"), new Food("coke"));

        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room("Bedroom", fruits));
        roomList.add(new Room("Dining room", vegetables));
        roomList.add(new Room("Kitchen", fastFood));
        roomList.add(new Room("Random room", randomFood));
        roomList.add(new Room("Noname room", drink));

        House house = new House(roomList);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            executorService.schedule(house::collectFood, 5, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All food collected");
        System.out.println("Collected food: " + house.getCollectedFood());
    }
}
