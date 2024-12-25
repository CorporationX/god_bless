package school.faang.wow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
