package faang.school.godbless.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    @NonNull
    private String name;
    @NonNull
    private List<Food> foodList;

    public List<Food> collectFoodFromRoom() {
        var removedFood = foodList;
        foodList = new ArrayList<>();

        return removedFood;
    }
}
