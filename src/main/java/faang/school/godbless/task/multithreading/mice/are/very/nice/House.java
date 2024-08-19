package faang.school.godbless.task.multithreading.mice.are.very.nice;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class House {
    private static final int THREAD_POOL_LIMIT = 5;
    private static final int THREAD_START_TIMER = 15;
    private static final int GATHER_TIME_LIMIT = 6;
    private static final int NUMBER_OF_ROOMS_PER_TIME = 2;

    private static final Logger logger = LoggerFactory.getLogger(House.class);
    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Food> foods = new ArrayList<>();

    public static void gatherFood(int houseIndex) {
        int limit = houseIndex + NUMBER_OF_ROOMS_PER_TIME;
        IntStream.range(houseIndex, Math.min(limit, rooms.size()))
                .forEach(i -> {
                    var room = rooms.get(i);
                    logger.info("\nСбор еды из комнаты: %s".formatted(room.getName()));
                    var roomFoods = room.getFoods();
                    System.out.println("Собранная еда:");
                    roomFoods.forEach(food -> System.out.println(food.getName()));
                    foods.addAll(roomFoods);
                    roomFoods.clear();
                });
    }

    public static void main(String[] args) {
        var fds = List.of(
                new Food("Пицца"),
                new Food("Сыр"),
                new Food("Колбаса"),
                new Food("Орехи")
        );
        rooms.addAll(List.of(
                new Room("Прихожая 1", new ArrayList<>(fds)),
                new Room("Спальня 1", new ArrayList<>(fds)),
                new Room("Кухня 1", new ArrayList<>(fds)),
                new Room("Ванная 1", new ArrayList<>(fds)),
                new Room("Прихожая 2", new ArrayList<>(fds)),
                new Room("Спальня 2", new ArrayList<>(fds)),
                new Room("Гостиная 1", new ArrayList<>(fds)),
                new Room("Гостиная 2", new ArrayList<>(fds)),
                new Room("Спальня 3", new ArrayList<>(fds)),
                new Room("Ванная 2", new ArrayList<>(fds)),
                new Room("Кухня 2", new ArrayList<>(fds))
        ));
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_POOL_LIMIT);
        IntStream.iterate(0, i -> i < rooms.size(), i -> i += NUMBER_OF_ROOMS_PER_TIME)
                .forEach(i -> {
                    scheduler.schedule(() -> gatherFood(i), i * THREAD_START_TIMER, TimeUnit.SECONDS);
                });
        scheduler.shutdown();
        try {
            if (scheduler.awaitTermination(GATHER_TIME_LIMIT, TimeUnit.MINUTES)) {
                logger.info("\nВся еда из дома собрана!");
                System.out.println(foods);
            } else {
                logger.warn("Мыши не успели собрать всю едй за %s минут".formatted(GATHER_TIME_LIMIT));
            }
        } catch (InterruptedException exception) {
            logger.error("Interrupted exception: {}", exception.getMessage());
        }
    }
}
