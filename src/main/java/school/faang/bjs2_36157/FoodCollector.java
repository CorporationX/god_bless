package school.faang.bjs2_36157;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Slf4j
public class FoodCollector {
    private final static int THREAD_QUANTITY = 5;
    private final List<Food> collectedFood = new ArrayList<>();
    private final House house;

    private ScheduledExecutorService scheduler;


    public FoodCollector(House house) {
        if (house == null) {
            throw new IllegalStateException("House is empty!");
        }
        this.house = house;
    }

    public void executeCollectFood() {
        scheduler = Executors.newScheduledThreadPool(THREAD_QUANTITY);

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            scheduler.scheduleAtFixedRate(this::collectFood, 0, 10, TimeUnit.SECONDS);
        }
    }

    private void collectFood() {
        Random random = new Random();

        List<Room> rooms = house.getRooms();
        if (rooms.size() < 2) {
            log.warn("Not enough processing rooms");
            return;
        }

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;

        do {
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while (room1.equals(room2));

        cleaningRoom(room1);
        cleaningRoom(room2);
    }

    private void cleaningRoom(Room room) {
        if (!room.getFoodList().isEmpty()) {
            ReentrantLock roomLock = room.getLock();
            if (roomLock.tryLock()) {
                try {
                    collectedFood.addAll(room.getFoodList());
                    log.info("Add foods in collection: " + room.getFoodList());
                    room.getFoodList().clear();
                    log.info("Clear food in room: " + room.hashCode());
                    log.info("Collected foods: " + collectedFood);

                    if (isAllRoomsEmpty()) {
                        log.info("All the food has been collected!");
                        scheduler.shutdown();
                    }
                } finally {
                    roomLock.unlock();
                }
            }
        } else {
            log.info("Room " + room.hashCode() + " already being processed, skipping");
        }
    }

    private boolean isAllRoomsEmpty() {
        List<Room> notEmptyRooms = house.getRooms().stream().filter(room -> !room.getFoodList().isEmpty()).toList();

        return notEmptyRooms.isEmpty();
    }
}
