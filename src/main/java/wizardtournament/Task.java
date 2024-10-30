package wizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String task;
    private int difficulty;
    private int reward;
}
