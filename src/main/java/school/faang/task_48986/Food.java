package school.faang.task_48986;

import lombok.Getter;

@Getter
public class Food {
    private final String foodName;

    public Food(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return '\'' + foodName + '\'';
    }
}
