package school.faang.task_48955;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Room {

    private List<Food> foodList;

    public Room() {
        foodList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            foodList.add(new Food("Food " + i));
        }
    }

    public void removeAllFood() {
        foodList.clear();
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
