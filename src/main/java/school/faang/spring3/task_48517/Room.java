package school.faang.spring3.task_48517;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> foods = new ArrayList<>();

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    public void removeAllFood() {
        foods.clear();
    }
}
