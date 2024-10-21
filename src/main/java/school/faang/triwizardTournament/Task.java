package school.faang.triwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
