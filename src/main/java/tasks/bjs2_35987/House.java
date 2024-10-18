package tasks.bjs2_35987;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class House {
    private static Random random = new Random();
    private static final List<Room> rooms = generatorRooms();
    private static final int THREAD_COUNT = 5;
    private static List<Food> collectedFoods = new ArrayList<>();
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        System.out.println(rooms);

        for(int i = 0; i < THREAD_COUNT; i++) {
            executor.scheduleAtFixedRate(House::collectFood, 1, 3, TimeUnit.SECONDS);
        }
    }

    private static void collectFood() {
        if (isRoomsWithoutFoods()) {
            System.out.println("В доме больше нет комнат с продуктами");

            if (!executor.isShutdown()) {
                executor.shutdown();
                System.out.println("Собранные продукты: " + collectedFoods);
            }

            return;
        }

        for(Room room : getRoomsForCollectionFood()) {
            synchronized (room) {
                if(!room.hasFood()) {
                    continue;
                }

                List<Food> collectFoods = room.collectFoods();

                synchronized (collectedFoods) {
                    collectedFoods.addAll(collectFoods);
                }
            }
        }
    }

    private static List<Room> generatorRooms() {
        List<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Кухня_1", generatorFoods()));
        rooms.add(new Room("Кухня_2", generatorFoods()));
        rooms.add(new Room("Гостиная", generatorFoods()));
        rooms.add(new Room("Спальня_1", generatorFoods()));
        rooms.add(new Room("Спальня_2", generatorFoods()));
        rooms.add(new Room("Спальня_3", generatorFoods()));
        rooms.add(new Room("Спальня_4", generatorFoods()));
        rooms.add(new Room("Кабинет_1", generatorFoods()));
        rooms.add(new Room("Кабинет_2", generatorFoods()));

        return rooms;
    }

    private static List<Food> generatorFoods() {
        List<String> FOOD_NAMES = Arrays.asList(
            "Яблоко", "Бутерброд", "Пицца", "Чай", "Кофе", "Печенье", "Сыр", "Колбаса", "Хлеб"
        );

        List<Food> foods = IntStream
            .range(0, random.nextInt(4) + 2)
            .mapToObj(i -> {
                int randomFoodIndex = random.nextInt(FOOD_NAMES.size());

                return new Food(FOOD_NAMES.get(randomFoodIndex));
            })
            .collect(Collectors.toList());

        return foods;
    }

    private static List<Room> getRoomsForCollectionFood() {
        return rooms.stream()
            .filter(Room::hasFood)
            .limit(2)
            .collect(Collectors.toList());
    }

    private static boolean isRoomsWithoutFoods() {
        return rooms.stream().filter(Room::hasFood).count() == 0;
    }
}
