package task_62137;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
