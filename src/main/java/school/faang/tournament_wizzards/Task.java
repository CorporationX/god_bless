package school.faang.tournament_wizzards;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {
    private final String name;
    private Difficulty difficulty;
    private int reward;

    enum Difficulty {
        EASY,
        MEDIUM,
        HARD;
    }
}
