package school.faang.bjs48591;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private volatile List<Room> roomsLeft;
    Random random;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        collectedFood = new ArrayList<>();
        roomsLeft = new ArrayList<>(rooms);
        random = new Random();
    }

    public void collectFood() {
        for (int roomsWorked = 0; roomsWorked < 2 && !roomsLeft.isEmpty(); roomsWorked++) {
            collectedFood.addAll(getRandomRoom());
        }
    }

    private List<Food> getRandomRoom() {
        int roomNumber = random.nextInt(roomsLeft.size());
        Room room = roomsLeft.get(roomNumber);

        if (!room.tryLock() || !roomsLeft.contains(room)) {
            return Collections.emptyList();
        }

        final var food = room.getFoodList();
        room.clearRoom();
        roomsLeft.remove(room);

        log.info("{} cleared room {}", Thread.currentThread().getName(), room.getNumber());
        room.unlock();
        return food;
    }

    public boolean allFoodCollected() {
        return roomsLeft.isEmpty();
    }

    public List<Food> getCollectedFood() {
        return List.copyOf(collectedFood);
    }
}
