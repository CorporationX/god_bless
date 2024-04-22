package faang.school.godbless.async.task_3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {
    private final String name;
    private int difficulty;
    private int reward;
}
