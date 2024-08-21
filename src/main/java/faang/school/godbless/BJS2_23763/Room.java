package faang.school.godbless.BJS2_23763;


import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {
    private final List<Food> foods = new ArrayList<>();

    public void addFoods(List<Food> foods) {
        this.foods.addAll(foods);
    }

    public List<Food > collectAllFoodsFromRoom() {
        List<Food> collectedFood = List.copyOf(foods);
        foods.removeAll(collectedFood);
        return collectedFood;
    }
}
