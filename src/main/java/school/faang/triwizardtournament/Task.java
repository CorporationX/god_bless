package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private String difficulty;
    private int reward;
}
