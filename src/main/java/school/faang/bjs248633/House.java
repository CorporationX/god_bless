package school.faang.bjs248633;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class House {

    private final List<Room> rooms;
    private final List<Food> collectedFoods;
    private final Random random;
    private static final int NUMBER_OF_ROOMS = 6;
    private final Set<Room> clearedRooms;
    @Getter
    private final CountDownLatch roomClearLatch;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFoods = new ArrayList<>();
        this.random = new Random();
        this.roomClearLatch = new CountDownLatch(NUMBER_OF_ROOMS);
        this.clearedRooms = new HashSet<>();

        log.info("House created. Ready to add rooms and collect food.\n");
    }

    public void initialize() {
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            Room room = new Room("Room number " + (i + 1));
            int foodCount = random.nextInt(10) + 1;
            for (int j = 0; j < foodCount; j++) {
                room.addFood(new Food("Dish food number " + (j + 1)));
            }
            addRoom(room);
        }
        log.info("House initialization completed. Rooms count: {}", rooms.size());

    }

    public synchronized void addRoom(Room room) {
        if (room == null) {
            log.warn("Attempted to add a null Room to the House.");
            throw new IllegalArgumentException("Room cannot be null.");
        }
        rooms.add(room);
        log.info("Room '{}' added to the House.", room.getRoomName());
    }

    public synchronized void collectFood() {
        List<Room> notEmptyRooms = new ArrayList<>();
        for (Room r : rooms) {
            if (!r.isClear()) {
                notEmptyRooms.add(r);
            }
        }

        if (notEmptyRooms.size() < 2) {
            log.warn("There are fewer than 2 non-empty rooms left. Cannot collect further.");
            return;
        }

        int firstIndex = random.nextInt(notEmptyRooms.size());
        int secondIndex = random.nextInt(notEmptyRooms.size());
        while (secondIndex == firstIndex) {
            secondIndex = random.nextInt(notEmptyRooms.size());
        }

        Room room1 = notEmptyRooms.get(firstIndex);
        Room room2 = notEmptyRooms.get(secondIndex);

        log.info("Collecting food from two random rooms: '{}' and '{}'.",
                room1.getRoomName(), room2.getRoomName());

        collectFoodFromRoom(room1);
        collectFoodFromRoom(room2);
    }

    private void collectFoodFromRoom(Room room) {
        List<Food> foodFromRoom = room.removeFood();
        if (!foodFromRoom.isEmpty()) {
            collectedFoods.addAll(foodFromRoom);
            log.debug("Collected {} items from Room '{}'.", foodFromRoom.size(), room.getRoomName());
        } else {
            log.debug("Room '{}' was empty. No items collected.", room.getRoomName());
        }

        if (room.isClear()) {
            roomClearLatch.countDown();
            log.info("Room '{}' became empty. Latch count: {}", room.getRoomName(), roomClearLatch.getCount());
            clearedRooms.add(room);
        }
    }
}