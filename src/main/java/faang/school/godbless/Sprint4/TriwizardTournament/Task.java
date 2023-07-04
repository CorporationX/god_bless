package faang.school.godbless.Sprint4.TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
