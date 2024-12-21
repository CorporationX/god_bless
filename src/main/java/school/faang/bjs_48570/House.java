package school.faang.bjs_48570;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Slf4j
public class House {
    private  static final int CLEANING_ROOMS_COUNT = 2;
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        List<Room> selectedRooms = new ArrayList<>();

        while (selectedRooms.size() <= CLEANING_ROOMS_COUNT && selectedRooms.size() <= rooms.size()) {
            Room room = getRandomRoom();

            if (!selectedRooms.contains(room)) {
                selectedRooms.add(getRandomRoom());
            }
        }

        selectedRooms
                .forEach(room -> {
                    log.info("Cleaning room: {}", room);

                    synchronized (collectedFood) {
                        room.getFoods()
                                .forEach(food -> {
                                    collectedFood.add(food);
                                    log.info("Removed food: {}", food);
                                });
                        room.getFoods().clear();
                    }
                });
    }

    public boolean isClean() {
        return rooms.stream()
                .allMatch(room -> room.getFoods().isEmpty());
    }

    private Room getRandomRoom() {
        Random random = new Random();
        int randomRoom = random.nextInt(rooms.size());
        return rooms.get(randomRoom);
    }
}
