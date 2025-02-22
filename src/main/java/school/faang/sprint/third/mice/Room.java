package school.faang.sprint.third.mice;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private final List<Food> foods;

    public Room(List<Food> foods) {
        validateFoods(foods);
        this.foods = foods;
    }

    private void validateFoods(List<Food> foods) {
        if (foods == null) {
            throw new IllegalArgumentException("Foods is null");
        }
        if (foods.isEmpty()) {
            throw new IllegalArgumentException("Foods is empty");
        }
    }
}
