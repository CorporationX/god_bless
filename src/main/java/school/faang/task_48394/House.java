package school.faang.task_48394;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class House {
    private static final int NUMBER_THREADS = 5;
    private static final long COMPLETION_PERIOD = 30;
    private static final long DELAY = 0;
    private static final int ROOM_LIMIT = 2;

    private final List<Room> roomList;
    private final List<Food> totalListFood = new ArrayList<>();
    private final int quantityRooms;

    public House(int quantityRooms) {
        this.quantityRooms = quantityRooms;
        roomList = new ArrayList<>(quantityRooms);
    }

    public static void main(String[] args) {
        House house = new House(8);
        ScheduledExecutorService executor = Executors
                .newScheduledThreadPool(NUMBER_THREADS);
        List<Food> foodList = List.of(
                new Food("Jerry"),
                new Food("Cheese"),
                new Food("Burger")
        );
        house.initializeRooms(foodList);

        executor.scheduleAtFixedRate(() -> {
            house.collectFood(ROOM_LIMIT);
            if (house.isAllFoodCollected()) {
                executor.shutdown();
            }
        }, DELAY, COMPLETION_PERIOD, TimeUnit.SECONDS);

        try {
            long programTimeout = house.getQuantityRooms() / ROOM_LIMIT
                    * COMPLETION_PERIOD;
            if (!executor.awaitTermination(programTimeout, TimeUnit.SECONDS)) {
                log.error("Not all tasks completed within the specified time period"
                        + ", forced termination");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while waiting {}", e.getMessage());
            executor.shutdownNow();
        }
        log.info("The food in the house is collected, only {} units",
                house.totalListFood.size());
    }

    public synchronized void collectFood(int roomLimit) {
        Collections.shuffle(roomList);
        List<Room> roomsCollectingFood = roomList.stream()
                .filter(Room::hasFood)
                .limit(roomLimit)
                .toList();

        roomsCollectingFood.forEach(room -> {
            totalListFood.addAll(room.getFoodList());
            room.clearRoom();
        });
    }

    private void initializeRooms(List<Food> foodList) {
        for (int i = 0; i < quantityRooms; i++) {
            var room = new Room();
            room.addFoodList(foodList);
            addRoom(room);
        }
    }

    private boolean isAllFoodCollected() {
        for (Room room : roomList) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }
}
