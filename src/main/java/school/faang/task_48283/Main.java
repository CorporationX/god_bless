package school.faang.task_48283;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = addHouseData();
        house.collectFood();
        System.out.println(house.toString());
//        ExecutorService executor = Executors.newScheduledThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            executor.submit(house.collectFood());
//        }
    }

    private static House addHouseData() {
        List<Room> rooms = new ArrayList<>();
        List<Food> kitchenFood = Arrays.asList(new Food("Banana"), new Food("Bred"));
        List<Food> bedroomFood = Arrays.asList(new Food("Vine"), new Food("Apple"));
        rooms.add(new Room("Kitchen", kitchenFood));
        rooms.add(new Room("Bedroom", bedroomFood));
        return new House(rooms);
    }
}
