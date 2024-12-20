package school.faang.nicemice;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
public class House {
    private static final int ROOMS_TO_COLLECT = 2;

    private final List<Room> rooms;
    private final List<Food> collectedFood;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initializeHouse(List<Room> initialRooms) {
        for (Room room : initialRooms) {
            addRoom(room);
        }
    }

    public void collectFood() {
        Collections.shuffle(rooms);
        rooms.stream()
                .filter(Room::hasFood)
                .limit(ROOMS_TO_COLLECT)
                .forEach(room -> {
                    collectedFood.addAll(room.getFoods());
                    log.info("{} собрал еду из комнаты {}", Thread.currentThread().getName(), room.getName());
                    room.removeAllFood();
                });
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}
