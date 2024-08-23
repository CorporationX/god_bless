package faang.school.godbless.BJS2_23857;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int NUM_OF_THREADS = 1;

    public static void main(String[] args) {
        List<Food> kitchenFoods = Arrays.asList(new Food("Bread"), new Food("Cheese"), new Food("Pasta"), new Food("Tomatoes"));

        List<Food> livingRoomFoods = Arrays.asList(new Food("Chips"), new Food("Soda"), new Food("Popcorn"));

        List<Food> diningRoomFoods = Arrays.asList(new Food("Roast Chicken"), new Food("Salad"), new Food("Wine"), new Food("Dessert"));

        List<Food> bedroomFoods = Arrays.asList(new Food("Cookies"), new Food("Milk"), new Food("Fruit"));

        Room kitchen = new Room(kitchenFoods);
        Room livingRoom = new Room(livingRoomFoods);
        Room diningRoom = new Room(diningRoomFoods);
        Room bedroom = new Room(bedroomFoods);

        List<Room> rooms = new ArrayList<>(Arrays.asList(kitchen, livingRoom, diningRoom, bedroom));

        House house = new House(rooms);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUM_OF_THREADS);

        house.getRoomList().forEach(room -> executorService.schedule(() -> room.collectFood(), 30, TimeUnit.SECONDS));

        executorService.shutdown();
    }
}
