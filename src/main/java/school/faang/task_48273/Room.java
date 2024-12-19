package school.faang.task_48273;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Room {
    private final String name;
    private final List<Food> foods = Collections.synchronizedList(new ArrayList<>());

    public void addFood(@NonNull Food food) {
        foods.add(food);
    }

    @Override
    public String toString() {
        return name;
    }
}
