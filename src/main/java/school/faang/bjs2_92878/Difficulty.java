package school.faang.bjs2_92878;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Difficulty {
    EASY(10),
    MEDIUM(20),
    HARD(40),
    PAIN(100);

    private final int difficultLevelPoints;
}
