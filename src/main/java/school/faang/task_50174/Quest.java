package school.faang.task_50174;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
