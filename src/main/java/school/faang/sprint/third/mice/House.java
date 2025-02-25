package school.faang.sprint.third.mice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private static final Random RANDOM = new Random();
    private final List<Room> rooms;
    private final List<Food> collectedFoods = new ArrayList<>();
    private final Object lock = new Object();

    public House(List<Room> rooms) {
        validateRooms(rooms);
        this.rooms = rooms;
    }

    public void collectFood() {
        synchronized (lock) {
            boolean isRoomHasFoods = rooms.parallelStream().anyMatch(room -> !room.getFoods().isEmpty());
            if (!isRoomHasFoods) {
                log.info("All foods are collected");
                return;
            }
            int roomNum = getRandomRoom();
            List<Food> roomFoods = rooms.get(roomNum).getFoods();
            while (roomFoods.isEmpty()) {
                roomFoods = rooms.get(getRandomRoom()).getFoods();
            }
            log.info("Collecting food {}", roomFoods);
            collectedFoods.addAll(roomFoods);
            roomFoods.clear();
        }
        log.info("Collected {} foods", collectedFoods.size());
    }

    private int getRandomRoom() {
        return RANDOM.nextInt(rooms.size());
    }

    private void validateRooms(List<Room> rooms) {
        if (rooms == null) {
            throw new IllegalArgumentException("Rooms is null");
        }
        if (rooms.isEmpty()) {
            throw new IllegalStateException("There are no foods in this house");
        }
    }
}
