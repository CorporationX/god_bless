package faang.school.godbless.BJS2_25080;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
    EASY(3000L), MEDIUM(5000L), HARD(10000L);

    private long executionTime;
}
