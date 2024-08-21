package mice;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Room {
    @Getter
    private final String roomName;
    private final List<Food> foods = new ArrayList<>();

    public Room(@NonNull String roomName, @NonNull List<Food> foods) {
        this.roomName = roomName;
        this.foods.addAll(foods);
    }

    public void addFood(@NonNull Food food) {
        foods.add(food);
    }

    public List<Food> collectFoodFromRoom() {
        System.out.printf("All food from %s collected!%n", roomName);
        var collectedFood = new ArrayList<>(foods);
        foods.clear();
        return collectedFood;
    }
}
