package faang.school.godbless.thirdsprint.thomasandjerry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class House {
    private final List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFoodFromTwoRooms() {
        Collections.shuffle(rooms);

        rooms.stream()
                .filter(Room::hasFood)
                .limit(2)
                .forEach(room -> {
                    List<Food> food = room.collectFood();
                    System.out.println("Собрано из комнаты '" + room.getName() + "': " + food);
                });
    }

    public boolean isFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        House house = new House();

        Room kitchen = new Room("Кухня");
        kitchen.addFood(new Food("Яблоко"));
        kitchen.addFood(new Food("Хлеб"));

        Room livingRoom = new Room("Гостиная");
        livingRoom.addFood(new Food("Сыр"));
        livingRoom.addFood(new Food("Молоко"));

        Room bedroom = new Room("Спальня");
        bedroom.addFood(new Food("Конфета"));
        bedroom.addFood(new Food("Печенье"));

        Room bathroom = new Room("Ванная");
        bathroom.addFood(new Food("Шоколад"));

        Room attic = new Room("Чердак");
        attic.addFood(new Food("Орешки"));

        house.addRoom(kitchen);
        house.addRoom(livingRoom);
        house.addRoom(bedroom);
        house.addRoom(bathroom);
        house.addRoom(attic);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        AtomicBoolean isShutdownInitiated = new AtomicBoolean(false);

        for (int i = 0; i < 5; i++) {
            executor.schedule(() -> {
                house.collectFoodFromTwoRooms();
                if (house.isFoodCollected() && isShutdownInitiated.compareAndSet(false, true)) {
                    executor.shutdown();
                    System.out.println("Еда в доме собрана!");
                }
            }, i * 30, TimeUnit.SECONDS);
        }

        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
