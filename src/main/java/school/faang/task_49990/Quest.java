package school.faang.task_49990;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Quest {
    private final String name;
    private final int difficult;
    private final int reward;
}
