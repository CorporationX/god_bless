package school.faang.sprint4.task_50824;

import lombok.Getter;

import java.util.Random;

import static school.faang.sprint4.task_50824.TaskParameters.EASY_TASK_MAX_REWARD;
import static school.faang.sprint4.task_50824.TaskParameters.EASY_TASK_TIME;
import static school.faang.sprint4.task_50824.TaskParameters.HARD_TASK_MAX_REWARD;
import static school.faang.sprint4.task_50824.TaskParameters.HARD_TASK_TIME;
import static school.faang.sprint4.task_50824.TaskParameters.MEDIUM_TASK_MAX_REWARD;
import static school.faang.sprint4.task_50824.TaskParameters.MEDIUM_TASK_TIME;

@Getter
public class Task {

    private final String name;
    private final Difficulty difficulty;
    private final int reward;
    private final int executionTime;

    public Task(String name, Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = generateReward();
        this.executionTime = switch (difficulty) {
          case EASY -> EASY_TASK_TIME;
          case MEDIUM -> MEDIUM_TASK_TIME;
          case HARD -> HARD_TASK_TIME;
        };
    }

    private int generateReward() {
        Random random = new Random();

        return switch (difficulty) {
          case EASY -> random.nextInt(EASY_TASK_MAX_REWARD);
          case MEDIUM -> EASY_TASK_MAX_REWARD + random.nextInt(MEDIUM_TASK_MAX_REWARD - EASY_TASK_MAX_REWARD);
          case HARD -> MEDIUM_TASK_MAX_REWARD + random.nextInt(HARD_TASK_MAX_REWARD - MEDIUM_TASK_MAX_REWARD);
        };
    }
}

