package school.faang.bjs2_36225.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Getter
@ToString
public class House {
    private final List<Room> rooms = Collections.synchronizedList(new ArrayList<>());

    public void addRooms(List<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    public void collectFood(@NonNull List<Food> collectedFood) {
        int randomIndexRoom1 = ThreadLocalRandom.current().nextInt(0, rooms.size());
        Room room1 = rooms.get(randomIndexRoom1);
        int randomIndexRoom2 = ThreadLocalRandom.current().nextInt(0, rooms.size());
        Room room2 = rooms.get(randomIndexRoom2);

        Stream.of(room1, room2)
                .filter(room -> !room.isFoodsEmpty())
                .forEach(room -> {
                    List<Food> foodsRoom = room.getFoods();
                    collectedFood.addAll(foodsRoom);
                    foodsRoom.clear();
                });
    }

    public boolean isAllFoodPacked() {
        return rooms.stream().allMatch(Room::isFoodsEmpty);
    }
}
