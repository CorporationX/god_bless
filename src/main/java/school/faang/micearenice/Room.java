package school.faang.micearenice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Room {

    private final String name;
    private final List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        if (food != null) {
            foods.add(food);
        }
    }

    public void clearFood() {
        foods.clear();
    }
}
