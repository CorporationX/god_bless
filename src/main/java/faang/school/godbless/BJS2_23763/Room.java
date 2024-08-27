package faang.school.godbless.BJS2_23763;


import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class Room {
    private final List<Food> foods = new ArrayList<>();

    public void addFoods(List<Food> foods) {
        this.foods.addAll(foods);
    }

    public Food getFood() {
        if (!foods.isEmpty())
            return foods.remove(0);
        else {
            throw new IndexOutOfBoundsException("Room is empty");
        }
    }

    public boolean isFoodHere() {
        return !foods.isEmpty();
    }
}
