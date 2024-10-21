package school.faang.wizardstournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
