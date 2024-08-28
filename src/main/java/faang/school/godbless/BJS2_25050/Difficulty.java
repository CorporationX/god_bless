package faang.school.godbless.BJS2_25050;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
    EASY(2000L), MEDIUM(4000L), HARD(6000L);

    private long executionTime;
}
