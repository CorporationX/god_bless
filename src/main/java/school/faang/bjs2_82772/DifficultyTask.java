package school.faang.bjs2_82772;

import lombok.Getter;

@Getter
public enum DifficultyTask {
    EASY(0), NORMAL(1), HARD(2), VERY_HARD(3), IMPOSSIBLE(5);

    private final int numberDifficulty;

    DifficultyTask(int numberDifficulty) {
        this.numberDifficulty = numberDifficulty;
    }
}
