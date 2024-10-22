package school.faang.bjs2_36157;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Slf4j
public class FoodCollector {
    private final static int THREAD_QUANTITY = 5;
    private final List<Food> collectedFood = new ArrayList<>();
    private final House house;
    private ScheduledExecutorService scheduler;

    public FoodCollector(House house) {
        if (house == null) {
            throw new IllegalStateException("Дом пуст!");
        }
        this.house = house;
    }

    public void executeCollectFood() {
        scheduler = Executors.newScheduledThreadPool(THREAD_QUANTITY);
        scheduler.scheduleAtFixedRate(this::collectFood, 0, 30, TimeUnit.SECONDS);
    }

    private void collectFood() {
        Collections.shuffle(house.getRooms());
        log.info("Get two random rooms...");

        house.getRooms().stream()
                .filter(room -> !room.getFoodList().isEmpty())
                .toList()
                .subList(0, 2)
                .forEach(room -> {
                    log.info("Select room with foods: " + room);
                    collectedFood.addAll(room.getFoodList());
                    log.info("Add foods in collection: " + room.getFoodList());
                    room.getFoodList().clear();
                    log.info("Clear food in room: " + room);
                });

        log.info("Collected foods: " + collectedFood);

        if (isAllRoomsEmpty()) {
            log.info("All the food has been collected!");
            scheduler.shutdown();
        }
    }

    private boolean isAllRoomsEmpty() {
        List<Room> notEmptyRooms = house.getRooms().stream().filter(room -> !room.getFoodList().isEmpty()).toList();

        return notEmptyRooms.isEmpty();
    }
}
