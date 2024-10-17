package school.faang.BJS2_36046_MiceAreNice;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Food> foodstuff;


    public Room(String name) {
        this.name = name;
        foodstuff = new ArrayList<>();
    }

    public Room(String name, List<Food> foodstuff) {
        this.name = name;
        this.foodstuff = new ArrayList<>(foodstuff);
    }

    public void addFood(Food food) {
        foodstuff.add(food);
    }

    public List<Food> collectAndClearFoodstuff() {
        List<Food> foodToCollect = new ArrayList<>(foodstuff);
        foodstuff.clear();
        System.out.printf("The food from %s has been collected: %s!\n", name, foodToCollect);
        return foodToCollect;
    }
}
