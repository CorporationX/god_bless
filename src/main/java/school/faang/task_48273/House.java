package school.faang.task_48273;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class House {
    private final List<Room> rooms = new ArrayList<>();
    @Getter
    private final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        while (true) {
            Map.Entry<Room, Room> roomEntry = getRandomRooms();
            Room firstRandomRoom = roomEntry.getKey();
            Room secondRandomRoom = roomEntry.getValue();

            if (firstRandomRoom == null || secondRandomRoom == null) {
                return;
            }

            if (firstRandomRoom.getLock().tryLock() && secondRandomRoom.getLock().tryLock()) {
                try {
                    synchronized (collectedFood) {
                        collectedFood.addAll(firstRandomRoom.collectFood());
                        collectedFood.addAll(secondRandomRoom.collectFood());
                    }
                } finally {
                    firstRandomRoom.getLock().unlock();
                    secondRandomRoom.getLock().unlock();
                }
                break;
            }
        }
    }

    public Map.Entry<Room, Room> getRandomRooms() {
        Room firstRandomRoom = rooms.stream()
                .filter(room -> !room.getFoods().isEmpty())
                .findAny()
                .orElse(null);

        Room secondRandomRoom = rooms.stream()
                .filter(room -> !room.getFoods().isEmpty()
                        && room != firstRandomRoom)
                .findAny()
                .orElse(null);

        return new AbstractMap.SimpleEntry<>(firstRandomRoom, secondRandomRoom);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
