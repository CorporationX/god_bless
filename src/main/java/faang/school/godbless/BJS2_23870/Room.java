package faang.school.godbless.BJS2_23870;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;

    public boolean remove(Food food) {
        return foods.remove(food);
    }

    public boolean contains(Food food) {
        return foods.contains(food);
    }
}
