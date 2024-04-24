package faang.school.godbless.async.task_5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}