package school.faang.bjs2_36225.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@ToString
public class Room {
    private final List<Food> foods = Collections.synchronizedList(new ArrayList<>());

    public boolean isFoodsEmpty() {
        return foods.isEmpty();
    }

    public void addFoods(List<Food> foods) {
        this.foods.addAll(foods);
    }
}
