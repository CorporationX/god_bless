package dima.evseenko.wizard;

import lombok.Getter;

@Getter
public enum Difficulty {
    EASY(1000),
    MEDIUM(2000),
    HARD(3000);

    private final int taskCompleteTime;

    Difficulty(int taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }
}
