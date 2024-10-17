package tom_Jerry;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> foods;

    public Room() {
        this.foods = new ArrayList<>();
    }

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room=" + foods +
                '}';
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> cleanRoom() {
        List<Food> collected = new ArrayList<>(foods);
        foods.clear();
        return collected;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
