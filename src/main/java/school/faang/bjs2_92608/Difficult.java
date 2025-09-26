package school.faang.bjs2_92608;

import lombok.Getter;

@Getter
public enum Difficult {
    EASY(1),
    MEDIUM(3),
    HARD(5),
    PAIN(15);

    private final int difficultScore;

    Difficult(int difficultScore) {
        this.difficultScore = difficultScore;
    }
}
