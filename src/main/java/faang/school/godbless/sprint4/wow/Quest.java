package faang.school.godbless.sprint4.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
