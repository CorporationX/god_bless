package faang.school.godbless.parallelismAndThread.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private List<Food> foodList;

    public Room() {
        this.foodList = new ArrayList<>();
    }

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public void clearFood() {
        this.foodList = Collections.emptyList();
    }
}
