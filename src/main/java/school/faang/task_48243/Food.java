package school.faang.task_48243;

import school.faang.exception.CheckException;

public class Food {
    private final String name;

    public Food(String foodName) {
        if (foodName == null || foodName.isEmpty()) {
            throw new CheckException("foodName");
        }

        this.name = foodName;
    }
}
