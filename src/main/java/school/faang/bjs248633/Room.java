package school.faang.bjs248633;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString

public class Room {
    private final List<Food> foodList;
    @Getter
    private final String roomName;

    public Room(String roomName) {
        if (roomName == null || roomName.trim().isEmpty()) {
            log.warn("Attempted to create Room with invalid name: '{}'", roomName);
            throw new IllegalArgumentException("Room name cannot be null or empty.");
        }
        this.roomName = roomName;
        this.foodList = new ArrayList<>();
        log.debug("Room created: {}", this.roomName);
    }

    public void addFood(Food food) {
        if (food == null) {
            log.warn("Attempted to add null Food to Room: {}", roomName);
            throw new IllegalArgumentException("Food cannot be null.");
        }
        foodList.add(food);
        log.debug("Food '{}' added to Room '{}'", food.foodName(), roomName);
    }

    public List<Food> removeFood() {
        List<Food> whatWasCollected = new ArrayList<>(foodList);
        foodList.clear();
        log.debug("All food cleared from Room '{}'. Removed items: {}", roomName, whatWasCollected);
        return whatWasCollected;
    }

    public boolean isClear() {
        return foodList.isEmpty();
    }
}