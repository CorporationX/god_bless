package school.faang.three_warlock_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
