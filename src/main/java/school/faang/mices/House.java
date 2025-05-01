package school.faang.mices;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Getter
public class House {

    private final ConcurrentLinkedQueue<Food> collectedFood;
    private final CopyOnWriteArrayList<Room> rooms;

    public House(List<Room> rooms) {
        Collections.shuffle(rooms);
        this.rooms = new CopyOnWriteArrayList<>(rooms);
        this.collectedFood = new ConcurrentLinkedQueue<>();
    }

    public void collectFood(int startRoomIndex, int endRoomIndex) {
        rooms
                .subList(startRoomIndex, endRoomIndex)
                .stream()
                .filter(Room::isFoodInTheRoom)
                .forEach(room -> collectedFood.add(room.peekFood()));
    }

    public synchronized boolean isAllRoomsEmpty() {
        return rooms.stream().noneMatch(Room::isFoodInTheRoom);
    }
}