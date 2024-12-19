package school.faang.spring3.task_48517;

import lombok.Getter;


import java.util.List;

@Getter
public class Room {
    private List<Food> foods;
    private final int number;

    public Room(List<Food> foods, int number) {
        this.foods = foods;
        this.number = number;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    public void removeAllFood() {
        foods.clear();
    }
}
