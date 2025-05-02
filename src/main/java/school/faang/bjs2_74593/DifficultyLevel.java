package school.faang.bjs2_74593;

import lombok.Getter;

@Getter
public enum DifficultyLevel {
    HEROIC(3000),
    NORMAL(1000),
    EASY(500),
    MYTHIC(5000);

    private final int sleepTime;

    DifficultyLevel(final int sleepTime) {
        this.sleepTime = sleepTime;
    }
}
