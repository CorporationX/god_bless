package school.faang.task_48314;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class House {
    private final List<Room> rooms;

    @Getter
    private volatile boolean allRoomsCleared;

    public House() {
        this.rooms = new ArrayList<>();
        this.allRoomsCleared = false;
    }

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        synchronized (rooms) {
            Consumer<Room> foodCollector = room -> {
                List<Food> removedFood = room.removeAllFoodFromRoom();
                removedFood.forEach(food -> log.info(food.toString()));
            };

            List<Room> roomsWithFood = getTwoRoomsWithFood();

            roomsWithFood.forEach(foodCollector);
            allRoomsCleared = roomsWithFood.isEmpty();
        }
    }

    private List<Room> getTwoRoomsWithFood() {
        return rooms.stream()
                .filter(Room::hasFood)
                .limit(2)
                .toList();
    }

}
