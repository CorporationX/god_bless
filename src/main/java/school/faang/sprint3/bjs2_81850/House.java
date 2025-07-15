package school.faang.sprint3.bjs2_81850;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class House {
    private static final int THREAD_BATCH = 5;
    private static final int TASK_INTERVAL = 5;
    private static final int GENERATE_FOOD_COUNT = 5;
    private static final int GENERATE_ROOM_COUNT = 5;
    private static final String FOOD_PREFIX = "food %s";

    @NonNull
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood() {
        Collections.shuffle(rooms);
        rooms.stream().limit(2).forEach(room -> {
            if (room.hasFood()) {
                System.out.printf("Собираю еду из комнаты: %s\n", room.getId());
                collectedFood.addAll(room.getAllFood());
            }
        });
    }

    public static void main(String[] args) {
        House house = new House(generateRooms(GENERATE_ROOM_COUNT));
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_BATCH);
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Сбор еды по комнатам");
            house.collectFood();
            if (house.getCollectedFood()) {
                System.out.println("Вся еда собрана");
                System.out.println("Собранная еда: " + house.collectedFood);
                executor.shutdown();
                try {
                    if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                        executor.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executor.shutdownNow();
                }
            }
        }, 0, TASK_INTERVAL, TimeUnit.SECONDS);
    }

    public static List<Room> generateRooms(int count) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Room room = new Room(i + 1, generateFood(GENERATE_FOOD_COUNT));
            rooms.add(room);
        }
        return rooms;
    }

    public static List<Food> generateFood(int count) {
        List<Food> foodList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = String.format(FOOD_PREFIX, i);
            Food food = new Food(name);
            foodList.add(food);
        }
        return foodList;
    }

    public boolean getCollectedFood() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}
