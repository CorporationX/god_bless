package school.faang.task_48273;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int THREAD_POOL_EXECUTE_PERIOD = 30;

    public static void main(String[] args) {
        House house = setUpHouse();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUM_THREADS);

        executorService.scheduleAtFixedRate(() -> {
            if (house.collectFood()) {
                executorService.shutdown();
            }
        }, 0, THREAD_POOL_EXECUTE_PERIOD, TimeUnit.MICROSECONDS);

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                log.info("Food is collected: {} {}", house.getCollectedFood(), house.getCollectedFood().size());
            } else {
                executorService.shutdownNow();
                log.info("Food is not collected");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private static House setUpHouse() {
        List<Food> foods = List.of(new Food("Cheese"), new Food("Steak"),
                new Food("Milk"), new Food("Cucumber"));

        List<Room> rooms = List.of(new Room(1), new Room(2),
                new Room(3), new Room(4));

        House house = new House();

        rooms.forEach(room -> {
            foods.forEach(room::addFood);
            house.addRoom(room);
        });

        return house;
    }
}
