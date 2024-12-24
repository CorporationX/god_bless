package school.faang.miceareverynicebjs48761;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private List<Food> foodItems;

    public Room() {
        this.foodItems = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodItems.add(food);
    }

    public Food removeRandomFood() {
        if (foodItems.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * foodItems.size());
        return foodItems.remove(randomIndex);
    }
}
