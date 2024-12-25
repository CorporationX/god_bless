package school.faang.sprint_3.task_48487;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Food {
    private final String name;

    public Food(String name) {
        this.name = name;
    }
}
