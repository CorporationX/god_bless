package school.faang.sprint4.task50400.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
