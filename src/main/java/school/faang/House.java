package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Slf4j
public class House {
    private final Random random = new Random();
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    private int notEmptyRooms;
    private static final int NUMBER_OF_ROOMS = 2;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        notEmptyRooms = rooms.size();
    }

    public synchronized void collectFood() {
        Set<Room> roomSet = new HashSet<>();
        while (roomSet.size() < Math.min(NUMBER_OF_ROOMS, notEmptyRooms)) {
            int index = random.nextInt(rooms.size());
            if (!rooms.get(index).getFoodList().isEmpty()) {
                roomSet.add(rooms.get(index));
            }
        }
        for (Room room : roomSet) {
            notEmptyRooms--;
            log.info("Collecting food from {}.", room);
            collectedFood.addAll(room.getFoodList());
            room.getFoodList().clear();
        }
    }

    public boolean isAllFoodCollected() {
        for (Room room : rooms) {
            if (!room.getFoodList().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
