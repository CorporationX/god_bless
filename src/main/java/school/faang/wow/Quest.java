package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Quest {

    private final String name;
    private final int difficulty;
    private final int reward;
}
