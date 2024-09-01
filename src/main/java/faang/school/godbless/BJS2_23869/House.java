package faang.school.godbless.BJS2_23869;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {

    private final List<Food> foodsInHouse;
    private final List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.foodsInHouse = new CopyOnWriteArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {

        var food = List.of(new Food("Banana"),new Food("Bread"),new Food("Meat"), new Food("Apple"), new Food("Crisps"), new Food("Pineapple"));

        Room bedroom = new Room(new ArrayList<>(food));
        Room bathroom = new Room(new ArrayList<>(food));
        Room kitchen = new Room(new ArrayList<>(food));
        Room bedroom1 = new Room(new ArrayList<>(food));
        Room bathroom1 = new Room(new ArrayList<>(food));
        Room kitchen1 = new Room(new ArrayList<>(food));

        List<Room> roomInHome = new ArrayList<>();
        roomInHome.add(bedroom);
        roomInHome.add(bathroom);
        roomInHome.add(kitchen);
        roomInHome.add(bedroom1);
        roomInHome.add(bathroom1);
        roomInHome.add(kitchen1);

        House house = new House(roomInHome);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int roomIndex1 = i * 2 % roomInHome.size();
            int roomIndex2 = (i * 2 + 1) % roomInHome.size();
            executor.schedule(() -> house.collectFood(roomIndex1, roomIndex2), 30 * i, TimeUnit.SECONDS);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        System.out.println("All food is collected");
    }

    public void collectFood(int roomIndex1, int roomIndex2) {
        List<Room> selectedRooms = Arrays.asList(rooms.get(roomIndex1), rooms.get(roomIndex2));
        selectedRooms.stream()
                .map(Room::collectRoomFoodAndClear)
                .forEach(foodsInHouse::addAll);
    }
}