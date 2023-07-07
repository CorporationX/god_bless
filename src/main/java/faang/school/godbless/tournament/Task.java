package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
