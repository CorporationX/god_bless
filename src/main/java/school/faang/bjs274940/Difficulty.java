package school.faang.bjs274940;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Difficulty {
    EASY(1_000),
    MEDIUM(3_000),
    HARD(5_000);

    private final int time;
}
