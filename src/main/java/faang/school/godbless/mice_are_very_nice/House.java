package faang.school.godbless.mice_are_very_nice;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void collectFood() {
        for (Room room : rooms) {
            collectedFood.addAll(room.getRoomsFood());
            room.clearFood();
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public static void main(String[] args) {
        House house = new House();
        Room room1 = new Room();
        room1.addFood(new Food("Apple"));
        room1.addFood(new Food("Cheese"));
        house.addRoom(room1);
        Room room2 = new Room();
        room2.addFood(new Food("Bread"));
        room2.addFood(new Food("Juice"));
        house.addRoom(room2);
        Room room3 = new Room();
        room3.addFood(new Food("Tomato"));
        room3.addFood(new Food("Cookie"));
        house.addRoom(room3);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.schedule(() -> {
                house.collectFood();
                System.out.println("Еда собрана за " + Thread.currentThread().getName());
            }, 30, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(200, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Вся еда в доме собрана");
    }
}