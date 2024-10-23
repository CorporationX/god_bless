package dima.evseenko.wow;

import lombok.Getter;

@Getter
public enum Difficulty {
    EASY(1000),
    MEDIUM(2000),
    HARD(3000);

    private final int questCompleteTime;

    Difficulty(int questCompleteTime) {
        this.questCompleteTime = questCompleteTime;
    }
}
