package faang.school.godbless.multithreading.mice;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ToString
public class House {

    private static final List<Room> cleanRooms = new ArrayList<>();

    private static final List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood(Room room) {
        collectedFood.addAll(room.foodList());
        room.foodList().clear();
        cleanRooms.add(room);
    }

    public static void main(String[] args) throws InterruptedException {

        List<Food> foodsFirstRoom = List.of(new Food("ice cream", "tasty", "small"),
                new Food("bread", "tasty", "small"),
                new Food("fish", "tasty", "small"),
                new Food("cheap", "tasty", "small"));

        List<Food> foodsSecondRoom = List.of(new Food("ice cream", "tasty", "small"),
                new Food("milk", "sweet", "small"),
                new Food("tomato", "tasty", "small"),
                new Food("paper", "spicy", "small"));

        List<Room> rooms = List.of(new Room(foodsFirstRoom), new Room(foodsSecondRoom));

        House house = new House();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (Room room : rooms) {
            executor.scheduleWithFixedDelay(() -> house.collectFood(room), 30, 5, TimeUnit.SECONDS);
        }

        if (executor.awaitTermination(15, TimeUnit.SECONDS)) {
            System.out.println("Долгая уборка");
        }
        executor.shutdown();

        System.out.println(cleanRooms);
        System.out.println(collectedFood);
    }
}