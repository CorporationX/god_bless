package school.faang.bjs2_36225;

import school.faang.bjs2_36225.model.Food;
import school.faang.bjs2_36225.model.House;
import school.faang.bjs2_36225.model.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());
        House house = createSampleHouse();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int j = 0; j < 5; j++) {
            scheduledExecutorService.scheduleAtFixedRate(() -> house.collectFood(collectedFood), 0, 30, TimeUnit.SECONDS);
        }

        while (!house.isAllFoodPacked()) {
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread was interrupted unexpectedly during sleep.");
            }
        }
        scheduledExecutorService.shutdown();
        System.out.println("The food in the house is packed!");
    }

    public static House createSampleHouse() {
        House house = new House();

        Room kitchen = new Room();
        Room livingRoom = new Room();
        Room bedroom = new Room();

        List<Room> rooms = List.of(kitchen, livingRoom, bedroom);
        house.addRooms(rooms);

        Food apple = new Food("Apple");
        Food banana = new Food("Banana");
        Food bread = new Food("Bread");
        Food milk = new Food("Milk");
        Food orange = new Food("Orange");
        Food cheese = new Food("Cheese");

        kitchen.addFoods(List.of(apple, bread, bread, bread, milk));
        livingRoom.addFoods(List.of(banana, banana, banana, orange));
        bedroom.addFoods(List.of(cheese, banana, banana));

        return house;
    }
}
