package school.faang.bjs274601;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Difficult {
    EASY(1_000),
    MEDIUM(3_000),
    HARD(5_000);

    private final int time;
}
