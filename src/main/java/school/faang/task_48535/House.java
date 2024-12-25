package school.faang.task_48535;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private static final int PERIOD = 30;
    private static final int TIME = 30;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFood() {

        Room room1 = rooms.stream()
                .filter(Room::hasFood)
                .findAny()
                .orElse(null);

        Room room2 = rooms.stream()
                .filter(r -> r.hasFood() && r != room1)
                .findAny()
                .orElse(null);

        if (room1 == null || room2 == null) {
            System.out.println("Все комнаты пусты!");
            return;
        }

        collectedFood.addAll(room1.getFoodList());
        collectedFood.addAll(room2.getFoodList());

        System.out.println("Собрали еду из комнат:");
        System.out.println("Комната 1: " + room1.getFoodList());
        System.out.println("Комната 2: " + room2.getFoodList());

        room1.getFoodList().clear();
        room2.getFoodList().clear();
    }

    public static void main(String[] args) {
        House house = new House();

        for (int i = 1; i <= 5; i++) {
            Room room = new Room();
            for (int j = 1; j <= 3; j++) {
                room.addFood(new Food("Еда" + i + "_" + j));
            }
            house.addRoom(room);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        Runnable task = house::collectFood;

        executor.scheduleAtFixedRate(task, 0, PERIOD, TimeUnit.SECONDS);
        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("Еда в доме собрана!");
            System.out.println("Собранная еда: " + house.collectedFood);
        }, TIME, TimeUnit.MINUTES);
    }
}
