package faang.school.godbless.thirdSprint;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Room {
    private final String name;
    private final List<Food> foodInsideRoom = new ArrayList<>();

    public void removeFood() {
        foodInsideRoom.clear();
    }

    public void addFood(Food food) {
        foodInsideRoom.add(food);
    }
}
