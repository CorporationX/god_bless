package faang.school.godbless.bjs2_23868;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private List<Food> foods;

    public Room(List<Food> foods) {
        this.foods = new ArrayList<>(foods);
    }

    public boolean isClean() {
        return foods.isEmpty();
    }

    public boolean isNotClean() {
        return !isClean();
    }


}
