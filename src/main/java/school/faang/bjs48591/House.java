package school.faang.bjs48591;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    public static final int MAX_SPACE = 2;
    public static final Random RANDOM;

    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private final List<Room> roomsLeft;

    static {
        RANDOM = new Random();
    }

    public House(List<Room> rooms) {
        this.rooms = rooms;
        collectedFood = new ArrayList<>();
        roomsLeft = new ArrayList<>(rooms);
    }

    public void collectFood() {
        for (int roomsCollected = 0; roomsCollected < MAX_SPACE && !roomsLeft.isEmpty(); roomsCollected++) {
            var foodFromRoom = cleanRandomRoom();
            if (foodFromRoom.isEmpty()) {
                roomsCollected--;
                continue;
            }
            this.collectedFood.addAll(foodFromRoom);
        }
    }

    private List<Food> cleanRandomRoom() {
        Room randomRoom;
        synchronized (roomsLeft) {
            int roomNumber = RANDOM.nextInt(roomsLeft.size());
            randomRoom = roomsLeft.get(roomNumber);
            roomsLeft.remove(randomRoom);
        }

        final var food = randomRoom.foodList();
        randomRoom.clearRoom();

        log.info("{} cleared room {}", Thread.currentThread().getName(), randomRoom.number());
        return food;
    }


    public boolean allFoodCollected() {
        return roomsLeft.isEmpty();
    }

    public List<Food> getCollectedFood() {
        return List.copyOf(collectedFood);
    }
}
