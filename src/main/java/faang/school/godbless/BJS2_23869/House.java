package faang.school.godbless.BJS2_23869;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            int startIndex = i * 2;
            executor.schedule(() -> house.collectFood(startIndex), 30 * i, TimeUnit.SECONDS);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        System.out.println("All food is collected");
    }

    public void collectFood(int startIndex) {
        List<Food> foodToCollect = IntStream.range(startIndex, Math.min(startIndex + 2, rooms.size()))
                .mapToObj(rooms::get)
                .flatMap(room -> room.collectFood().stream())
                .toList();

        foodsInHouse.addAll(foodToCollect);
    }
}