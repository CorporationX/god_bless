package school.faang.bjs248223.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final Set<Food> collectedFood = new HashSet<>();

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            Room randomSelectedRoom = rooms.stream().filter(room -> !room.getFoods().isEmpty()).findAny().orElse(null);
            if (randomSelectedRoom == null) {
                break;
            }
            List<Food> foods = randomSelectedRoom.getFoods();
            collectedFood.addAll(foods);
            randomSelectedRoom.getFoods().clear();
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
