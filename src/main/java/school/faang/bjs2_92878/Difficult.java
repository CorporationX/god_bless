package school.faang.bjs2_92878;

import lombok.Getter;

@Getter
public enum Difficult {
    EASY(10),
    MEDIUM(20),
    HARD(40),
    PAIN(100);

    private final int difficultLevelPoints;

    Difficult(int difficultLevelPoints) {
        this.difficultLevelPoints = difficultLevelPoints;
    }
}
