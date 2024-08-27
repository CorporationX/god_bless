package faang.school.godbless.niceMice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Food> collectedFood = new ArrayList<>();

    public static void addRoom(Room room) {
        rooms.add(room);
    }

    private static boolean ifEnoughRoomsWithFood() {
        return rooms.stream()
                .filter(room -> !room.isCollected())
                .toList()
                .size() < 2;
    }

    private static void collectingFoodInRoom(int i) {
        rooms.get(i).setCollected(true);
        collectedFood.addAll(rooms.get(i).getFood());
    }

    public static synchronized void collectFood() {
        if (ifEnoughRoomsWithFood()) {
            System.out.println("Not enough rooms with food to collect it");
            return;
        }
        for (int i = 0; i < rooms.size(); i += 2) {
            if (!rooms.get(i).isCollected() && !rooms.get(i + 1).isCollected()) {
                collectingFoodInRoom(i);
                collectingFoodInRoom(i + 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        addRoom(new Room("Bedroom", List.of(new Food("Cheese"), new Food("Chicken wings"))));
        addRoom(new Room("Living room", List.of(new Food("Sausages"), new Food("Waffles"))));
        addRoom(new Room("Bathroom", List.of(new Food("Chips"), new Food("Burger"))));
        addRoom(new Room("Attic", List.of(new Food("Sandwich"), new Food("Doughnuts"))));
        addRoom(new Room("Kitchen", List.of(new Food("Milk"), new Food("Candies"))));
        addRoom(new Room("Office", List.of(new Food("Soup"), new Food("Cookies"))));
        addRoom(new Room("Gym", List.of(new Food("Coke"), new Food("Pizza"))));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.schedule(House::collectFood, 30, TimeUnit.SECONDS);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Collected food: " + collectedFood);
    }
}
