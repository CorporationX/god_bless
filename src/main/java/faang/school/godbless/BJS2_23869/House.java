package faang.school.godbless.BJS2_23869;

import lombok.Getter;

import java.util.ArrayList;
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

        List<Room> roomInHome = new ArrayList<>();
        roomInHome.add(bedroom);
        roomInHome.add(bathroom);
        roomInHome.add(kitchen);

        House house = new House(roomInHome);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.schedule(house::collectFood, 30 * i, TimeUnit.SECONDS);
        }
        house.getRooms().forEach(room -> room.getFoodInRoom().clear());
        executor.shutdown();
        if (!executor.awaitTermination(120, TimeUnit.SECONDS)){
            executor.shutdown();
        } else {
            System.out.println("All food is collected");
        }
    }

    public void collectFood() {
        rooms.stream().flatMap(r -> r.getFoodInRoom().stream()).forEach(foodsInHouse::add);
    }
}