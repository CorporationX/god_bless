package school.faang.bjs2_74883;

import lombok.Getter;

@Getter
public enum Difficulty {
    EASY(1000),
    MEDIUM(2000),
    HARD(3000);

    private final int sleepTime;

    Difficulty(int sleepTime) {
        this.sleepTime = sleepTime;
    }

}
