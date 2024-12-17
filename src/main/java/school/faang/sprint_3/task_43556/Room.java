package school.faang.sprint_3.task_43556;

import java.util.List;

public record Room(String name, List<Food> foodList) {
    public void removeAllFood() {
        foodList.clear();
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
