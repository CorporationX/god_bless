package faang.school.godbless.MiceAreVeryNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private static final List<Food> COLLECTED_FOOD = new ArrayList<>();

    public static void main(String[] args) {
        House house = new House();

        Room kitchen = new Room("kitchen");
        kitchen.addFood(new Food("melon"));
        kitchen.addFood(new Food("cheese"));
        house.addRoom(kitchen);

        Room livingRoom = new Room("livingRoom");
        livingRoom.addFood(new Food("apple"));
        livingRoom.addFood(new Food("grapes"));
        house.addRoom(livingRoom);

        Room bedroom = new Room("bedroom");
        bedroom.addFood(new Food("banana"));
        bedroom.addFood(new Food("chocolate"));
        house.addRoom(bedroom);

        Room bathroom = new Room("bathroom");
        bathroom.addFood(new Food("orange"));
        bathroom.addFood(new Food("cookies"));
        house.addRoom(bathroom);

        Room diningRoom = new Room("diningRoom");
        diningRoom.addFood(new Food("bread"));
        diningRoom.addFood(new Food("butter"));
        house.addRoom(diningRoom);

        Room garage = new Room("garage");
        garage.addFood(new Food("water"));
        garage.addFood(new Food("energy bar"));
        house.addRoom(garage);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < house.getRooms().size(); i += 2) {
            Room room1 = house.getRooms().get(i);
            Room room2 = (i + 1 < house.getRooms().size()) ? house.getRooms().get(i + 1) : null;

            executorService.schedule(() -> collectFood(room1, room2), 30, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1,TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        COLLECTED_FOOD.forEach(f -> System.out.println(f.getName()));
        System.out.println("отработано");
    }

    public static void collectFood(Room room1, Room room2) {
        if (room1 != null) {
            COLLECTED_FOOD.addAll(room1.getFood());
            room1.getFood().clear();
        }
        if (room2 != null) {
            COLLECTED_FOOD.addAll(room2.getFood());
            room2.getFood().clear();
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
