package school.faang.task49960;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Difficulty {
    LOW(1),
    MIDDLE(3),
    HIGH(5);

    private final int second;
}
