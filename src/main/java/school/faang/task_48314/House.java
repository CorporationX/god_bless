package school.faang.task_48314;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class House {
    private final List<Room> rooms;

    public House() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        Consumer<Room> foodCollector = room -> {
            List<Food> removedFood = room.removeAllFoodFromRoom();
            removedFood.forEach(System.out::println);
        };

        foodCollector.accept(getRandomRoomThatHasFood());
        foodCollector.accept(getRandomRoomThatHasFood());
    }

    private Room getRandomRoomThatHasFood() {
        return rooms.stream()
                .filter(Room::hasFood)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No rooms with food found"));
    }

}
