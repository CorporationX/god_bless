package school.faang.cleanhouse;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int MAX_ROOM_COUNT = 10;
    private static final int TIME_WAIT_TO_EXECUTOR = 30;
    private static final int MAX_TIME_WAIT = 100;
    private static final int COUNT_ROOM_TO_CLEAN = 2;

    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectFood = new ArrayList<>();
    private Random random = new Random();

    public void initialize() {
        List<String> roomNames = List.of("Гостинная", "Прихожая", "Ванная", "Спальня", "Чердак", "Гараж", "Кухня");
        List<String> foodNames = List.of("Хлеб", "Яблоко", "Помидор", "Огурец", "Колбаса", "Сыр", "Молоко", "Соус");

        for(int i = 0; i < random.nextInt(MAX_ROOM_COUNT); i++) {
            List<Food> foods = List.of(new Food(foodNames.get(random.nextInt(foodNames.size()))));
            rooms.add(new Room(roomNames.get(random.nextInt(roomNames.size())), foods));
        }
    }
    public synchronized void collectFood() {
        for (int i = 0; i < COUNT_ROOM_TO_CLEAN; i++) {
            Room roomToClean = rooms.get(random.nextInt(rooms.size()));
            collectFood.addAll(roomToClean.getFoods().stream().toList());
            roomToClean.removeAllFood();
        }
    }

    public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        for(int i = 0; i < THREAD_POOL_SIZE; i++) {
            executor.scheduleAtFixedRate(() -> {
                if (house.allFoodCollected()) {
                    executor.shutdown();
                } else {
                    house.collectFood();
                }
            }, 0, TIME_WAIT_TO_EXECUTOR, TimeUnit.SECONDS);
        }

        if (executor.awaitTermination(MAX_TIME_WAIT, TimeUnit.SECONDS)) {
            System.out.println("Еда в доме собрана!");
        }
    }
}