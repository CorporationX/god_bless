package school.faang.sprint3.bjs_48206;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Integer> takenRooms;
    private final List<Food> collectedFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        takenRooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
    }

    public void collectFood() {
        Room room = rooms.get(getRoomForCleaning());
        if (!room.isRoomCleaned()) {
            collectedFood.addAll(room.getFoodFromRoom());
            log.info("Food collected from room {}", room.getRoomNumber());
        }
    }

    private synchronized int getRoomForCleaning() {
        Random random = new Random();
        int indexRoomInList;
        do {
            indexRoomInList = random.nextInt(rooms.size());
        } while (takenRooms.contains(indexRoomInList));
        takenRooms.add(indexRoomInList);
        return indexRoomInList;
    }

    public boolean allFoodCollected() {
        boolean workDone = true;
        for (Room room : rooms) {
            workDone &= room.isRoomCleaned();
        }
        return workDone;
    }
}
