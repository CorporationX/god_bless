package faang.school.godbless.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;

    public void addFood(Food food) {
        foods.add( food );
    }
}
