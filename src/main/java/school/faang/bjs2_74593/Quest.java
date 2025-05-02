package school.faang.bjs2_74593;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private String name;
    private DifficultyLevel difficultyLevel;
    private int reward;
}
