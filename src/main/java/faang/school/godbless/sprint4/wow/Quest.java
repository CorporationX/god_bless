package faang.school.godbless.sprint4.wow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
