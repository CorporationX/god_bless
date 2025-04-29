package school.faang.hogwarts;

import lombok.Getter;

@Getter
public enum DifficultyType {
    EASY(1), MEDIUM(5), HARD(10);
    private final int points;

    DifficultyType(int points) {
        this.points = points;
    }
}
