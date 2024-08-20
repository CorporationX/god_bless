package mice;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        Room room1 = new Room("kitchen", List.of(
                new Food("bread"), new Food("ham"),
                new Food("chicken"), new Food("cheese")));
        Room room2 = new Room("dining room", List.of(
                new Food("apple"), new Food("crackers"),
                new Food("banana"), new Food("cookies")));
        house.addRoom(room1);
        house.addRoom(room2);
        try (ScheduledExecutorService executor = Executors.newScheduledThreadPool(5)) {
            house.rooms.forEach(room -> executor.schedule(
                    () -> house.collectFood(room), 30, TimeUnit.SECONDS));
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All foods in house collected!");
                house.foods.forEach(System.out::println);
            } else {
                System.out.println("Time is up!");
            }
        }

    }

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public void collectFood(@NonNull Room room) {
        while (room.isRoomHasFood()) {
            var food = room.collectSomeFoodFromRoom();
            if (food.isPresent()) {
                foods.add(food.get());
                System.out.printf("%s collected from %s%n", food.get().getFoodName(), room.getRoomName());
            }
        }
        System.out.printf("All food from %s collected%n", room.getRoomName());
    }
}
