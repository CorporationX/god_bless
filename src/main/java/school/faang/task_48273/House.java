package school.faang.task_48273;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private final Random random = new Random();
    private final List<Room> rooms = new ArrayList<>();
    @Getter
    private final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        while (true) {
            Room firstRandomRoom = getRandomRoom();
            Room secondRandomRoom = getRandomRoom();

            if (firstRandomRoom == null || secondRandomRoom == null) {
                return;
            }

            if (!firstRandomRoom.getLock().isLocked() && !secondRandomRoom.getLock().isLocked()) {
                firstRandomRoom.getLock().lock();
                secondRandomRoom.getLock().lock();
                try {
                    collectedFood.addAll(firstRandomRoom.collectFood());
                    collectedFood.addAll(secondRandomRoom.collectFood());
                } finally {
                    firstRandomRoom.getLock().unlock();
                    secondRandomRoom.getLock().unlock();
                }
                return;
            }
        }
    }

    public Room getRandomRoom() {
        try {
            return rooms.stream().filter(room -> !room.getLock().isLocked()
                    && !room.getFoods().isEmpty()).toList().get(random.nextInt(rooms.size()));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
