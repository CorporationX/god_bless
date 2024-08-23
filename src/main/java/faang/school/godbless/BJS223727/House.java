package faang.school.godbless.BJS223727;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Getter
@Slf4j
@AllArgsConstructor
public class House {
    private final List<Room> rooms;
    private final List<Food> foods;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.foods = new CopyOnWriteArrayList<>();  // Используем потокобезопасный список
    }

    public static void main(String[] args) {
        List<Room> rooms = Arrays.asList(
                new Room("Kitchen", new ArrayList<>(Arrays.asList(new Food("Apple"), new Food("Bread")))),
                new Room("Living Room", new ArrayList<>(Arrays.asList(new Food("Milk"), new Food("Cookies")))),
                new Room("Bedroom", new ArrayList<>(Arrays.asList(new Food("Juice"), new Food("Chocolate")))),
                new Room("Hallway", new ArrayList<>(Arrays.asList(new Food("Water"), new Food("Chips")))),
                new Room("Basement", new ArrayList<>(Arrays.asList(new Food("Cheese"), new Food("Wine")))),
                new Room("Garage", new ArrayList<>(Arrays.asList(new Food("Sandwich"), new Food("Cola")))),
                new Room("Attic", new ArrayList<>(Arrays.asList(new Food("Cake"), new Food("Coffee"))))
        );

        House house = new House(rooms);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        final int SELECTED_ROOMS_NUM = 2;
        List<Room> selectedRooms = new ArrayList<>();

        IntStream.range(0, house.getRooms().size())
                .filter(counter -> counter % 2 == 0)
                .forEach(oddRoomNumber -> executor.schedule(() -> {
                    house.collectFood(house.getRooms().get(oddRoomNumber));
                    if(house.getRooms().size() > oddRoomNumber + 1){
                        house.collectFood(house.getRooms().get(oddRoomNumber + 1));
                    }
                }, 30, TimeUnit.SECONDS));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(100, TimeUnit.SECONDS)) {
                System.out.println("Forced shutdown");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Shutdown interrupted");
            executor.shutdownNow();
        }

        System.out.println("All food has been collected.");
    }

    public void collectFood(Room room) {
            foods.addAll(room.getFoods());
            room.getFoods().clear();
            System.out.println(Thread.currentThread().getName() + ": Food collected from room " + room.getName());

    }
}
