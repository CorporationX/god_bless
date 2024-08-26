package faang.school.godbless.task.multithreading.async.three.magitian.tournament;

import lombok.Getter;

@Getter
public class Task {
    private static final int REWARD_COEFFICIENT = 10;

    private final String name;
    private final int difficulty;
    private final int reward;

    public Task(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = difficulty / REWARD_COEFFICIENT;
    }
}
