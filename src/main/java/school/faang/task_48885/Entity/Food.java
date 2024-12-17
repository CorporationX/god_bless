package school.faang.task_48885.Entity;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Food {
    private final String foodTitle;

    public Food(String foodTitle) {
        this.foodTitle = foodTitle;
    }
}
