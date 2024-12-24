package school.faang.task_50793;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}
