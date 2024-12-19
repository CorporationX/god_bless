package school.faang.nicemice;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
public class House {
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
        int amountRoom = 2;
        Collections.shuffle(rooms);
        rooms.stream()
                .filter(Room::hasFood)
                .limit(amountRoom)
                .forEach(room -> {
                    collectedFood.addAll(room.getFoods());
                    log.info("{} собрал еду из комнаты {}", Thread.currentThread().getName(), room.getName());
                    room.removeAllFood();
                });
    }

    public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }
}
