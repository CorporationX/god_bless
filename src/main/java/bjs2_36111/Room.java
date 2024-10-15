package bjs2_36111;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Room {
    private final List<Food> foods;

    public Room(List<Food> foods) {
        this.foods = new ArrayList<>(foods);
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
