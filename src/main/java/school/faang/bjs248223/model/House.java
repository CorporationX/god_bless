package school.faang.bjs248223.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final Set<Food> collectedFood = new HashSet<>();

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            Optional<Room> anyRoom = rooms.stream().filter(room -> !room.getFoods().isEmpty()).findAny();
            anyRoom.ifPresent(room -> {
                List<Food> foods = room.getFoods();
                collectedFood.addAll(foods);
                foods.clear();
            });
        }
    }

    public void add(List<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    @Override
    public String toString() {
        return this.collectedFood.toString();
    }
}
