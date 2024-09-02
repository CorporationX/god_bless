package faang.school.godbless.BJS2_25111;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Quest {
    private String name;
    @Getter
    private int difficulty;
    private int reward;
}
