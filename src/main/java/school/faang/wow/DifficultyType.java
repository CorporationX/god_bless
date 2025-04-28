package school.faang.wow;

import lombok.Getter;

@Getter
public enum DifficultyType {
    EASY(1), MEDIUM(5), HARD(10);
    private final int complexity;

    DifficultyType(int difficulty) {
        this.complexity = difficulty;
    }
}
