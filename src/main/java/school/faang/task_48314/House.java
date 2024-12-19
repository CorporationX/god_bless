package school.faang.task_48314;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Slf4j
public class House {
    private final List<Room> rooms;

    private boolean allRoomsCleared;

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

            Stream.of(
                    getRandomRoomWithFood(), getRandomRoomWithFood()
            ).forEach(optionalRoom ->
                    optionalRoom.ifPresentOrElse(foodCollector, () -> this.allRoomsCleared = true));
        }
    }

    private Optional<Room> getRandomRoomWithFood() {
        return rooms.stream()
                .filter(Room::hasFood)
                .findAny();
    }

    public boolean isAllRoomsCleared() {
        synchronized (rooms) {
            return allRoomsCleared;
        }
    }

}
