package school.faang.miceverynice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static school.faang.ConcurrentUtils.shutdownExecutor;
import static school.faang.ConcurrentUtils.tryLockAndDo;
import static school.faang.miceverynice.Food.apple;
import static school.faang.miceverynice.Food.avocado;
import static school.faang.miceverynice.Food.banana;
import static school.faang.miceverynice.Food.cabbage;
import static school.faang.miceverynice.Food.cherry;
import static school.faang.miceverynice.Food.grape;
import static school.faang.miceverynice.Food.greens;
import static school.faang.miceverynice.Food.orange;
import static school.faang.miceverynice.Food.pear;
import static school.faang.miceverynice.Food.pineapple;
import static school.faang.miceverynice.Food.radish;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "House")
@RequiredArgsConstructor
public class House {

    private static final int ROOM_NUMBERS = 5;
    private static final int FOOD_PER_ROOM = 5;
    private static final int MAX_RANDOM_ROOMS = 2;
    private static final int THREADS_NUM = 5;
    private static final int TASK_INTERVAL = 30;

    private final Random rand = new Random();
    private final Lock lock = new ReentrantLock();
    private final List<Food> allCollectedFood = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        var house = new House();
        house.initialize();
        var executor = Executors.newScheduledThreadPool(THREADS_NUM);
        for (int i = 0; i < THREADS_NUM; i++) {
            executor.scheduleAtFixedRate(house::collectFood, 0, TASK_INTERVAL, TimeUnit.SECONDS);
        }
        while (!house.isAllFoodCollected()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        shutdownExecutor(executor, 5, TimeUnit.SECONDS);
        log.info("Еда в доме собрана!");
    }

    public void initialize() {
        var foods = List.of(avocado(), apple(), orange(), pear(), banana(),
                pineapple(), greens(), cabbage(), cherry(), grape(), radish());
        for (int i = 0; i < ROOM_NUMBERS; i++) {
            var foodsToRoom = new ArrayList<Food>();
            for (int j = 0; j < FOOD_PER_ROOM; j++) {
                foodsToRoom.add(foods.get(rand.nextInt(foods.size())));
            }
            addRoom(new Room("Room-%d".formatted(i), foodsToRoom));
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        tryLockAndDo(lock, () -> {
            for (int i = 0; i < MAX_RANDOM_ROOMS; i++) {
                var room = rooms.get(rand.nextInt(rooms.size()));
                if (room.hasFood()) {
                    var food = room.retrieveFood();
                    allCollectedFood.add(food);
                }
            }
        });
    }

    public boolean isAllFoodCollected() {
        return tryLockAndDo(lock, () -> allCollectedFood.size() == ROOM_NUMBERS * FOOD_PER_ROOM);
    }
}
