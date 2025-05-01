package school.faang.mices;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class Room {

    private final int roomNumber;
    private final ConcurrentLinkedQueue<Food> roomFood;

    public Room(int roomNumber, List<Food> roomFood) {
        this.roomNumber = roomNumber;
        this.roomFood = new ConcurrentLinkedQueue<>(roomFood);
    }

    public Food peekFood() {
        log.info("Peek food from {}", this);
        return roomFood.poll();
    }

    public boolean isFoodInTheRoom() {
        if (roomFood.isEmpty()) {
            log.info("{} is empty", this);
        }
        return !roomFood.isEmpty();
    }

    @Override
    public String toString() {
        return "%d - %s".formatted(roomNumber, roomFood);
    }
}