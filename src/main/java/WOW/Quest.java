package WOW;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
