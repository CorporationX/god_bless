package faang.school.godbless.multi_paral.task7mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }
}
