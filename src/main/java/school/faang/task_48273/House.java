package school.faang.task_48273;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class House {
    private final List<Room> rooms = Collections.synchronizedList(new ArrayList<>());
    @Getter
    private final List<Food> collectedFoods = Collections.synchronizedList(new ArrayList<>());
    private final RandomRoom randomRoom = new RandomRoom(rooms);

    public synchronized void collectFood() {
        Room firstRandomRoom = randomRoom.getRandomRoom();
        Room secondRandomRoom = randomRoom.getRandomRoom();

        if (firstRandomRoom.getFoods().isEmpty() || secondRandomRoom.getFoods().isEmpty()) {
            log.warn("There should be food in the rooms: {}, {}", firstRandomRoom, secondRandomRoom);
            return;
        }

        List<Food> foodsFromFirstRandomRoom = new ArrayList<>(firstRandomRoom.getFoods());
        List<Food> foodsFromSecondRandomRoom = new ArrayList<>(secondRandomRoom.getFoods());

        log.info("The list of food from the first random room {}: {}", firstRandomRoom, foodsFromFirstRandomRoom);
        log.info("The list of food from the second random room {}: {}", secondRandomRoom, foodsFromSecondRandomRoom);

        collectedFoods.addAll(foodsFromFirstRandomRoom);
        collectedFoods.addAll(foodsFromSecondRandomRoom);

        firstRandomRoom.getFoods().clear();
        secondRandomRoom.getFoods().clear();
    }

    public synchronized boolean allFoodCollected() {
        int foodCollectedCounter = 0;

        for (Room room : rooms) {
            if (room.getFoods().isEmpty()) {
                foodCollectedCounter++;
            }
        }

        return foodCollectedCounter == rooms.size();
    }

    public synchronized void addRoom(@NonNull Room room) {
        rooms.add(room);
    }
}
