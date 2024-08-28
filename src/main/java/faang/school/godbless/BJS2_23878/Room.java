package faang.school.godbless.BJS2_23878;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private String title;
    private final List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        this.foods.add(food);
    }
}
