package school.faang_sprint_3.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;

public record Room(String name, List<Food> foodList) {

    public List<Food> removeAllFood() {
        var copy = new ArrayList<>(foodList);
        if (hasFood()) {
            foodList.removeAll(copy);
        }
        return copy;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
