package school.faang.mice_nice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final int THREAD_COUNT = 5;
    private static final int FOOD_COUNT_PER_COLLECTFOOD = 5;
    private static final LinkedList<Room> rooms = new LinkedList<>();
    private static final List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) {

        House house = new House();
        house.addRoom("Kitchen 1", new ArrayList<>(List.of(
                new Food("pizza"),
                new Food("tomato"),
                new Food("potat3o"),
                new Food("beer"))));
        house.addRoom("Kitchen 2", new ArrayList<>(List.of(
                new Food("pizza"),
                new Food("tomato"),
                new Food("potato"),
                new Food("beer"))));
        house.addRoom("Kitchen 3", new ArrayList<>(List.of(
                new Food("pizza"),
                new Food("tomato"),
                new Food("wine"),
                new Food("beer"))));
        house.addRoom("Bathroom 1", new ArrayList<>(List.of(
                new Food("paper"),
                new Food("water"))));
        house.addRoom("Bathroom 2 ", new ArrayList<>(List.of(
                new Food("paper"),
                new Food("water"))));
        house.addRoom("Living room 1", new ArrayList<>(List.of(
                new Food("pizza"),
                new Food("potato chips"),
                new Food("potato"),
                new Food("beer"))));
        house.addRoom("Living room 2", new ArrayList<>(List.of(
                new Food("pizza"),
                new Food("potato chips"),
                new Food("potato"),
                new Food("beer"))));
        house.addRoom("Living room 3", new ArrayList<>(List.of(
                new Food("pizza"),
                new Food("potato chips"),
                new Food("potato"),
                new Food("beer"))));
        house.addRoom("Living room 4", new ArrayList<>(List.of(
                new Food("pizza"),
                new Food("potato chips"),
                new Food("potato"),
                new Food("beer"))));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_COUNT);

        for (int i = 1; i <= 5; i++) {
            executor.scheduleAtFixedRate(House::collectFood, 100 * i, 30, TimeUnit.MILLISECONDS);
        }

        executor.scheduleAtFixedRate(() -> {
            if (!isThereUntidyFood()) {
                executor.shutdown();
                System.out.println("Mission complete!");
                System.out.println(collectedFood.toString());
            }
        }, 3, 31, TimeUnit.SECONDS);
    }

    private static void collectFood() {
        Room currentRoom;

        for (int i = 1; i <= FOOD_COUNT_PER_COLLECTFOOD; i++) {
            currentRoom = rooms.pollFirst();
            if (currentRoom != null && !currentRoom.getFoods().isEmpty()) {
                collectedFood.addAll(currentRoom.collect());
                System.out.println("collected");
            }
        }
    }

    public void addRoom(String name, List<Food> foods) {
        rooms.add(new Room(name, foods));
    }

    private static boolean isThereUntidyFood() {
        return rooms.stream().anyMatch(room -> !room.getFoods().isEmpty());
    }
}
