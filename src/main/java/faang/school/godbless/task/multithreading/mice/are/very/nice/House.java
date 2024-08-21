package faang.school.godbless.task.multithreading.mice.are.very.nice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class House {
    private static final int THREAD_POOL_LIMIT = 5;
    private static final int THREAD_START_TIMER = 15;
    private static final int GATHER_TIME_LIMIT = 6;
    private static final int NUMBER_OF_ROOMS_PER_TIME = 2;

    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Food> collectingFoods = new ArrayList<>();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_POOL_LIMIT);

    public static void main(String[] args) {
        addRoomsToList();
        printFoodsInRooms();
        IntStream.iterate(0, i -> i < rooms.size(), i -> i += NUMBER_OF_ROOMS_PER_TIME)
                .forEach(i -> scheduler.schedule(() ->
                        gatherFood(getRoomsByRange(i)), i * THREAD_START_TIMER, TimeUnit.SECONDS));
        scheduler.shutdown();
        printResult(scheduler);
    }

    public static void gatherFood(List<Room> rooms) {
        rooms.forEach(room -> {
            log.info("\nСбор еды из комнаты: {}", room.getName());
            var roomFoods = room.getFoods();
            System.out.println("Собранная еда:");
            roomFoods.forEach(food -> System.out.println(food.getName()));
            collectingFoods.addAll(roomFoods);
            roomFoods.clear();
        });
    }

    private static List<Room> getRoomsByRange(int roomIndex) {
        int limit = roomIndex + NUMBER_OF_ROOMS_PER_TIME;
        return IntStream.range(roomIndex, Math.min(limit, rooms.size()))
                .mapToObj(rooms::get)
                .toList();
    }

    private static void printResult(ScheduledExecutorService scheduler) {
        try {
            if (scheduler.awaitTermination(GATHER_TIME_LIMIT, TimeUnit.MINUTES)) {
                log.info("\nВся еда из дома собрана!");
                printFoodsInRooms();
            } else {
                log.warn("Мыши не успели собрать всю едй за {} минут", GATHER_TIME_LIMIT);
            }
        } catch (InterruptedException exception) {
            log.error("Interrupted exception: {}", exception.getMessage());
        }
    }

    private static void printFoodsInRooms() {
        rooms.forEach(room -> {
            System.out.println("Список еды из комнаты %s: %s".formatted(room.getName(), room.getFoods()));
        });
    }

    private static void addRoomsToList() {
        var foods = getCollectingFoods();
        rooms.addAll(List.of(
                new Room("Прихожая 1", new ArrayList<>(foods)),
                new Room("Спальня 1", new ArrayList<>(foods)),
                new Room("Кухня 1", new ArrayList<>(foods)),
                new Room("Ванная 1", new ArrayList<>(foods)),
                new Room("Прихожая 2", new ArrayList<>(foods)),
                new Room("Спальня 2", new ArrayList<>(foods)),
                new Room("Гостиная 1", new ArrayList<>(foods)),
                new Room("Гостиная 2", new ArrayList<>(foods)),
                new Room("Спальня 3", new ArrayList<>(foods)),
                new Room("Ванная 2", new ArrayList<>(foods)),
                new Room("Кухня 2", new ArrayList<>(foods))
        ));
    }

    private static List<Food> getCollectingFoods() {
        return List.of(
                new Food("Пицца"),
                new Food("Сыр"),
                new Food("Колбаса"),
                new Food("Орехи")
        );
    }
}
