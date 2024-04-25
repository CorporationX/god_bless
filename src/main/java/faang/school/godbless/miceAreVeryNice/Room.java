package faang.school.godbless.miceAreVeryNice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }
}
