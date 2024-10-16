package school.faang.cleanhouse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeAllFood() {
        foods = new ArrayList<>();
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
