package faang.school.godbless.triwizard.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
