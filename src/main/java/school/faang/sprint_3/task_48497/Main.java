package school.faang.sprint_3.task_48497;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    static final int POOL_SIZE = 7;
    static final int DELAY = 1;
    static final int FREQUENCY = 2;

    @SneakyThrows
    public static void main(String[] args) {
        House house = setupHouse();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            if (house.collectFood()) {
                executor.shutdown();
            }
        }, DELAY, FREQUENCY, TimeUnit.SECONDS);

        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            log.info("Food is collected {}", house.getCollectedFood().size());
        } else {
            executor.shutdownNow();
            log.info("Food is not collected");
        }
    }

    private static House setupHouse() {
        List<Food> foods = List.of(new Food("Cheese"), new Food("Steak"),
            new Food("Milk"), new Food("Cucumber"));

        List<Room> rooms = List.of(new Room(1), new Room(2),
            new Room(3), new Room(4), new Room(5), new Room(6));

        House house = new House();

        rooms.forEach(room -> {
            foods.forEach(room::addFood);
            house.addRoom(room);
        });

        return house;
    }
}
