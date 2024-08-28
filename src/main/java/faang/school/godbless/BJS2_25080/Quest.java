package faang.school.godbless.BJS2_25080;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quest {
    private String name;
    private Difficulty difficulty;
    private int reward;

    public long getExecutionTime() {
        return difficulty.getExecutionTime();
    }
}
