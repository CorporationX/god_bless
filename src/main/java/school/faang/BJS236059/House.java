package school.faang.BJS236059;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private final List<Room> roomList;
    private final List<Food> collectedFoodList = new ArrayList<>();

    public House(List<Room> roomList) {
        this.roomList = roomList;
    }

    public synchronized void collectFood() {
        Random random = new Random();
        Room firstRoom = roomList.get(random.nextInt(roomList.size()));
        Room secondRoom;
        do {
            secondRoom = roomList.get(random.nextInt(roomList.size()));
        } while (firstRoom == secondRoom);

        List<Food> collectedFood = new ArrayList<>(firstRoom.getFood());
        collectedFood.addAll(secondRoom.getFood());

        firstRoom.getFood().clear();
        secondRoom.getFood().clear();

        collectedFoodList.addAll(collectedFood);

        System.out.println("Еда собрана из двух комнат и добавлена в общий список!");
    }

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();

        Room room1 = new Room(1, new ArrayList<>());
        room1.addFood(new Food("Apple"));
        room1.addFood(new Food("Banana"));

        Room room2 = new Room(2, new ArrayList<>());
        room2.addFood(new Food("Bread"));

        Room room3 = new Room(3, new ArrayList<>());
        room3.addFood(new Food("Orange"));
        room3.addFood(new Food("Chicken"));

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        House house = new House(rooms);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, 5, TimeUnit.SECONDS);
        }

        executorService.schedule(() -> {
            executorService.shutdown();
            System.out.println("Еда в доме собрана!");
        }, 2, TimeUnit.MINUTES);
    }
}
