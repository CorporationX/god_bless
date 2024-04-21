package faang.school.godbless.mice;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

@Slf4j
@Getter
public class House {

    private List<Room> rooms;
    private List<Food> collectedFood;
    private static final int AMOUNT_THREADS = 5;

    public static void main(String[] args) {
        House house = new House();


        ScheduledExecutorService executor = newScheduledThreadPool(AMOUNT_THREADS);

        for (int i = 0; i < AMOUNT_THREADS; i++) {
            Room room1 = house.getRooms().get(i);
            Room room2 = house.getRooms().get(i + AMOUNT_THREADS);
            executor.schedule(() -> house.collectFood(room1, room2, house.getCollectedFood()), 30, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(150, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Food collecting was interrupted.", e);
            return;
        }
        log.info("All food was collected. Collected food: " + house.getCollectedFood());
    }

    private void collectFood(Room room1, Room room2, List<Food> collectedFood) {
        if (room1 == null || room2 == null) {
            return;
        }

        log.info("Collecting food from " + room1.getName() + " and " + room2.getName());

        collectedFood.addAll(room1.collectFoodFromRoom());
        collectedFood.addAll(room2.collectFoodFromRoom());
    }

    public House() {

        rooms = new ArrayList<>();

        List<Food> foodList1 = List.of(new Food("Apple"), new Food("Orange"));
        List<Food> foodList2 = List.of(new Food("Pizza"), new Food("Burger"));
        List<Food> foodList3 = List.of(new Food("Salad"), new Food("Sandwich"));
        List<Food> foodList4 = List.of(new Food("Pasta"), new Food("Steak"));
        List<Food> foodList5 = List.of(new Food("Cake"), new Food("Ice Cream"));
        List<Food> foodList6 = List.of(new Food("Apple"), new Food("Orange"));
        List<Food> foodList7 = List.of(new Food("Pizza"), new Food("Burger"));
        List<Food> foodList8 = List.of(new Food("Salad"), new Food("Sandwich"));
        List<Food> foodList9 = List.of(new Food("Pasta"), new Food("Steak"));
        List<Food> foodList10 = List.of(new Food("Cake"), new Food("Ice Cream"));

        rooms.add(new Room("Room 1", foodList1));
        rooms.add(new Room("Room 2", foodList2));
        rooms.add(new Room("Room 3", foodList3));
        rooms.add(new Room("Room 4", foodList4));
        rooms.add(new Room("Room 5", foodList5));
        rooms.add(new Room("Room 6", foodList6));
        rooms.add(new Room("Room 7", foodList7));
        rooms.add(new Room("Room 8", foodList8));
        rooms.add(new Room("Room 9", foodList9));
        rooms.add(new Room("Room 10", foodList10));

        collectedFood = new ArrayList<>();
    }
}
