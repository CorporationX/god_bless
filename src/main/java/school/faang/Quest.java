package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private final String name;
    private Difficulty difficulty;
    private int reward;

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD;
    }
}
