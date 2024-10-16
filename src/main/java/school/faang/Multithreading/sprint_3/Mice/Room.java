package school.faang.Multithreading.sprint_3.Mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Room {
    private final String name;
    private final List<Food> foods = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeAllFood() {
        foods.clear();
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Room room = (Room) obj;

        return Objects.equals(this.name, room.name);
    }
}
