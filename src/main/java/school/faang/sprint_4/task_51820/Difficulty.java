package school.faang.sprint_4.task_51820;

import lombok.Getter;

@Getter
public enum Difficulty {
    EASY(2000),
    MEDIUM(3000),
    HARD(4000);

    private int timeToComplete;

    Difficulty(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
}
