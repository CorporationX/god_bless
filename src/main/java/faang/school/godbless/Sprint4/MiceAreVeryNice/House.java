package faang.school.godbless.Sprint4.MiceAreVeryNice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House implements Runnable {
    List<Room> rooms = new ArrayList<>();
    List<Room> clearRooms = new ArrayList<>();
    Map<Food, Integer> collegiateFood = new HashMap<>();
    int quantity = 5;

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.initialize();
        System.out.println("Данно: " + house.rooms);
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(house.quantity);
        executors.schedule(house, 5, TimeUnit.SECONDS);
        executors.shutdown();
        executors.awaitTermination(10, TimeUnit.SECONDS);
        System.out.printf("Вся еда собрана\nСобрали:");
        house.collegiateFood.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + "в количестве" + e.getValue()));
    }

    @Override
    public void run() {
        collectFood();
    }

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            List<Food> foods = rooms.get(0).getFoods();
            for (Food food : foods) {
                collegiateFood.put(food, collegiateFood.getOrDefault(food, 0) + 1);
            }
            rooms.get(0).getFoods().clear();
            clearRooms.add(rooms.get(0));
            rooms.remove(0);
        }
    }

    public void initialize() {
        List<Food> foods = List.of(new Food("Apple"),
                new Food("Banana"),
                new Food("Orange"),
                new Food("Cherry"),
                new Food("Strawberry"));
        List<Room> rooms = List.of(new Room("Kitchen"),
                new Room("Living room"),
                new Room("Bedroom"));
        for (Room room : rooms) {
            for (int i = 0; i < 2; i++) {
                room.getFoods().add(foods.get((int) (Math.random() * foods.size())));
            }
        }
    }
}
