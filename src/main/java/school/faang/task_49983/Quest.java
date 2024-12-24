package school.faang.task_49983;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
