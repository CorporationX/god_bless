package faang.school.godbless.BJS2_25050;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private String name;
    private Difficulty difficulty;
    private int reward;

    public long getExecutionTime() {
        return difficulty.getExecutionTime();
    }
}
