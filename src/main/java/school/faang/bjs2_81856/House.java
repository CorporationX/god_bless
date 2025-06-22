package school.faang.bjs2_81856;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class House {
    private static final int ROOMS_TO_COLLECT_COUNT = 2;
    private final Random random = new Random();
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood() {
        for (int i = 0; i < ROOMS_TO_COLLECT_COUNT; i++) {
            Room room = getRandomRoom();
            log.info("Collected food from room {}", room);
            collectedFood.addAll(room.clearFoodList());
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }

    private Room getRandomRoom() {
        Room room;
        do {
            int roomIndex = random.nextInt(rooms.size());
            room = rooms.get(roomIndex);
        } while (!room.hasFood());

        return room;
    }
}
