package school.faang.mice.nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private List<Food> foods = new ArrayList<>();

    public Room(Food... foods) {
        this.foods.addAll(List.of(foods));
    }
}
