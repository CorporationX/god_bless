package school.faang.bjs_48570;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Slf4j
public class House {
    private static final int CLEANING_ROOMS_COUNT = 2;
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    private final List<Room> cleanedRooms = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        List<Room> selectedRooms = getRoomList();

        synchronized (rooms) {
            cleanedRooms.addAll(selectedRooms);
        }

        if (selectedRooms.isEmpty()) {
            return;
        }
        log.info("Selected rooms: {}", selectedRooms);

        selectedRooms.forEach(room -> {
            log.info("Cleaning room: {}", room);
            synchronized (collectedFood) {
                collectedFood.addAll(room.getFoods());
            }
            log.info("Removed food: {}", room.getFoods());
            room.getFoods().clear();
        });
    }

    public boolean isClean() {
        synchronized (rooms) {
            return rooms.stream()
                    .allMatch(room -> room.getFoods().isEmpty());
        }
    }

    private List<Room> getRoomList() {
        List<Room> roomList;
        synchronized (rooms) {
            Collections.shuffle(rooms);
            roomList = rooms.stream()
                    .filter(room -> !room.getFoods().isEmpty())
                    .filter(room -> !cleanedRooms.contains(room))
                    .limit(CLEANING_ROOMS_COUNT)
                    .toList();
            return roomList;
        }
    }
}
