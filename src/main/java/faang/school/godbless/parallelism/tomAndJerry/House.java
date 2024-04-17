package faang.school.godbless.parallelism.tomAndJerry;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Slf4j
public class House {
    public static final int DELAY = 30;
    public static final int N_THREADS = 5;
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        rooms = new ArrayList<>();

        List<Food> foodList1 = List.of(new Food("Apple"), new Food("Banana"));
        List<Food> foodList2 = List.of(new Food("Pizza"), new Food("Burger"), new Food("Fries"));
        List<Food> foodList3 = List.of(new Food("Salad"), new Food("Sandwich"), new Food("Soup"));
        List<Food> foodList4 = List.of(new Food("Pasta"), new Food("Steak"));
        List<Food> foodList5 = List.of(new Food("Sushi"), new Food("Rice"), new Food("Noodles"));
        List<Food> foodList6 = List.of(new Food("Cake"), new Food("Ice Cream"));
        List<Food> foodList7 = List.of(new Food("Taco"), new Food("Burrito"), new Food("Quesadilla"));
        List<Food> foodList8 = List.of(new Food("Pancake"), new Food("Waffle"), new Food("French Toast"));
        List<Food> foodList9 = List.of(new Food("Chicken Wings"), new Food("Nachos"), new Food("Guacamole"));
        List<Food> foodList10 = List.of(new Food("Cereal"), new Food("Milk"));

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

    public static void main(String[] args) {
        House house = new House();

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(N_THREADS);

        log.info("Starting food collecting");

        for (int i = 0; i < N_THREADS; i++) {
            var room1 = house.getRooms().get(i);
            var room2 = house.getRooms().get(i + N_THREADS);

            threadPool.schedule(() -> house.collectFood(room1, room2, house.getCollectedFood()), DELAY, TimeUnit.SECONDS);
        }

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(DELAY * N_THREADS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Food collecting was interrupted.", e);
            return;
        }

        log.info("All food was collected. Collected food: " + house.getCollectedFood());
    }

    public void collectFood(Room room1, Room room2, List<Food> collectedFood) {
        if (room1 == null || room2 == null) {
            return;
        }

        log.info("Collecting food from " + room1.getName() + " and " + room2.getName());

        collectedFood.addAll(room1.collectFoodFromRoom());
        collectedFood.addAll(room2.collectFoodFromRoom());
    }
}
