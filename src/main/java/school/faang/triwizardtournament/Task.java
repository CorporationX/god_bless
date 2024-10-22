package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private DifficultyLevels difficulty;
    private int reward;
}
