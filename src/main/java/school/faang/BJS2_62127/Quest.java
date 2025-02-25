package school.faang.BJS2_62127;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Quest {

    private final String name;
    private final Difficulty difficulty;
    private final int reward;
}
