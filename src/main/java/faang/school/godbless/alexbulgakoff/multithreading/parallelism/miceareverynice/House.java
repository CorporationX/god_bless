package faang.school.godbless.alexbulgakoff.multithreading.parallelism.miceareverynice;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class House {

    private final List<Room> rooms;
    private final List<Food> foods = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) throws InterruptedException {
        House house = initialize();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < house.getRooms().size(); i++) {
            long delay = i * 5L;
            scheduledExecutorService.schedule(() -> {
                System.out.println("Collecting is run!");
                synchronized (house) {
                    house.collectFood();
                }
            }, delay, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();

        scheduledExecutorService.awaitTermination(5, TimeUnit.MINUTES);

        System.out.println();
        System.out.println("All foods is collected");
        System.out.println(house.foods);

    }

    private static House initialize() {
        List<Room> rooms = List.of(
                new Room("Kitchen", List.of(new Food("Dry food"), new Food("Milk"), new Food("Cheese"),
                        new Food("Water"))),
                new Room("Hall", List.of(new Food("Water"))),
                new Room("Bedroom", List.of(new Food("Dry food"), new Food("Milk"))));


        return new House(rooms);
    }

    public void collectFood() {
        for (Room room : rooms) {
            System.out.println("Begin collecting food in " + room.getName());
            foods.addAll(room.getFoods());
            System.out.println("Collected in " + room.getName());
            // При использовании метода clear() в цикле обрабатывается только одна комната во всех потоках
            room.setFoods(List.of());
        }
    }
}
