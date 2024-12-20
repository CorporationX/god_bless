package school.faang.sprint3.task_48385;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static school.faang.sprint3.task_48385.Food.BANANA;
import static school.faang.sprint3.task_48385.Food.BECKON;
import static school.faang.sprint3.task_48385.Food.BREAD;
import static school.faang.sprint3.task_48385.Food.CHEESE;
import static school.faang.sprint3.task_48385.Food.MILK;

@Slf4j
public class Main {
    private static final int NUM_OF_ROOMS_TO_PROCESS = 2;
    private static final int PAUSE_BETWEEN_EXECUTIONS = 30;
    private static final int POOL_SIZE = 5;
    private static final List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());
    private static final House house = new House();

    public static void main(String[] args) {
        initRoomList(house);
        house.shuffleRooms();

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(POOL_SIZE);
        pool.scheduleAtFixedRate(Main::handleRooms, 0, PAUSE_BETWEEN_EXECUTIONS, TimeUnit.SECONDS);

        synchronized (house) {
            while (!house.isAllFoodCollected()) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    log.info("Thread has been interrupted: {}. Shut down the pool and finish execution", e.toString());
                    pool.shutdown();
                    return;
                }
            }
        }

        log.info("The list of collected foods is {}. All the food in the house has been collected !", collectedFood);
        pool.shutdown();
    }

    public static void handleRooms() {
        int i = 0;

        while (i < NUM_OF_ROOMS_TO_PROCESS) {
            try {
                Room room = house.assignRoom();
                List<Food> yieldedFood = house.collectFromRoom(room);
                collectedFood.addAll(yieldedFood);
                log.info("{} : Food {} has been yielded from the room with id {}",
                        Thread.currentThread().getName(), yieldedFood, room.id());
            } catch (IndexOutOfBoundsException e) {
                log.error(e.toString());
                synchronized (house) {
                    house.notifyAll();
                }
                break;
            } catch (InterruptedException e) {
                log.error("{} has been interrupted while processing room. Exception: {}",
                        Thread.currentThread().getName(), e.toString());
                return;
            }
            i++;
        }
    }

    public static void initRoomList(House house) {
        int id = 1;
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BANANA, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(MILK, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BECKON, BECKON))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BREAD, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BANANA, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(MILK, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BECKON, BECKON))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BREAD, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BANANA, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(MILK, CHEESE, MILK))
        ));
        house.addRoom(new Room(id++,
                new ArrayList<>(Arrays.asList(BECKON, BECKON))
        ));
        house.addRoom(new Room(id,
                new ArrayList<>(Arrays.asList(BREAD, CHEESE, MILK))
        ));
    }
}
