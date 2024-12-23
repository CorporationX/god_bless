package school.faang.bjs248633;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {

    private final List<Room> rooms;
    private final List<Food> collectFoods;
    private final Random random;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectFoods = new ArrayList<>();
        this.random = new Random();
        log.info("House created. Ready to add rooms and collect food.\n");
    }

    public void addRoom(Room room) {
        if (room == null) {
            log.warn("Attempted to add a null Room to the House.");
            throw new IllegalArgumentException("Room cannot be null.");
        }
        rooms.add(room);
        log.info("Room '{}' added to the House.", room.getRoomName());
    }

    public void collectFood() {
        if (rooms.size() < 2) {
            log.warn("Not enough rooms to collect food. Current rooms count: {}", rooms.size());
            return;
        }
        int firstRoom = random.nextInt(rooms.size());
        int secondRoom = random.nextInt(rooms.size());

        Room room1 = rooms.get(firstRoom);
        Room room2 = rooms.get(secondRoom);

        log.info("Collecting food from two random rooms: '{}' and '{}' ", room1.getRoomName(), room2.getRoomName());

        List<Food> fromRoom1 = room1.removeFood();
        if (!fromRoom1.isEmpty()) {
            collectFoods.addAll(fromRoom1);
            log.debug("Collected {} items from Room '{}'", fromRoom1.size(), room1.getRoomName());
        } else {
            log.debug("Room '{}' was empty. No items collected.", room1.getRoomName());
        }

        List<Food> fromRoom2 = room2.removeFood();
        if (!fromRoom2.isEmpty()) {
            collectFoods.addAll(fromRoom2);
            log.debug("Collected {} items from Room '{}'", fromRoom2.size(), room2.getRoomName());
        } else {
            log.debug("Room '{}' was empty. No items collected.", room2.getRoomName());
        }
        log.info("Total collected foods : {}", collectFoods.size());
    }
}

