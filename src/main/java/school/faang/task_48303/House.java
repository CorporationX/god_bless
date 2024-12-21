package school.faang.task_48303;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<Room> rooms = new ArrayList<>();
    @Getter
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized boolean collectFood() {
        List<Room> roomsWithFood = rooms.stream()
                .filter(Room::hasFood)
                .limit(2)
                .toList();

        if (roomsWithFood.isEmpty()) {
            return true;
        }

        roomsWithFood.forEach(room -> {
            collectedFood.addAll(room.collectAllFood());
            log.info("{} собрал еду из комнаты {}", Thread.currentThread().getName(), room.getNumber());
        });

        return false;
    }

}