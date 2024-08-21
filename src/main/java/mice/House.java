package mice;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final long DELAY = 30;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        var house = initHouse();
        try (ScheduledExecutorService executor = Executors.newScheduledThreadPool(5)) {
            int batchCount = house.rooms.size() / 2;
            for (int i = 0; i < batchCount; i++) {
                var batch = List.of(house.rooms.get(i * 2), house.rooms.get(i * 2 + 1));
                executor.schedule(() -> house.collectFood(batch), DELAY * i, TimeUnit.SECONDS);
            }
            if (house.rooms.size() / 2 != 0) {
                executor.schedule(() -> house.collectFood(List.of(house.rooms.get(house.rooms.size() - 1))),
                        DELAY * batchCount, TimeUnit.SECONDS);
            }
            executor.shutdown();
            if (executor.awaitTermination(DELAY * house.rooms.size(), TimeUnit.SECONDS)) {
                System.out.println("All foods in house collected:");
                house.foods.forEach(System.out::println);
            } else {
                System.out.println("Time is up!");
            }
        }

    }

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public static House initHouse() {
        House house = new House();
        Room room1 = new Room("kitchen", List.of(
                new Food("bread"), new Food("ham"),
                new Food("chicken"), new Food("cheese")));
        Room room2 = new Room("dining room", List.of(
                new Food("apple"), new Food("crackers"),
                new Food("banana"), new Food("cookies")));
        Room room3 = new Room("basement", List.of(
                new Food("jam"), new Food("canned soup")));
        Room room4 = new Room("bedroom", List.of(
                new Food("cholocate bar"), new Food("potato cheeps")));
        Room room5 = new Room("bathroom", List.of(
                new Food("brandy")));
        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);
        house.addRoom(room4);
        house.addRoom(room5);
        return house;
    }

    public void collectFood(@NonNull List<Room> rooms) {
        rooms.forEach(room -> foods.addAll(room.collectFoodFromRoom()));
    }
}
