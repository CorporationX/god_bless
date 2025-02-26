package school.faang.sprint4.bjs2_63654;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Quest {
    private static final int MIN_DIFFICULTY = 1;
    private static final int MAX_DIFFICULTY = 3;
    private static final int MIN_REWARD = 1;
    private static final int MAX_REWARD = 100;

    private final String name;
    private final int difficulty;
    private final int reward;

    public Quest(@NonNull String name, int difficulty, int reward) {
        this.name = validateName(name);
        this.difficulty = validateDifficulty(difficulty);
        this.reward = validateReward(reward);
    }

    private String validateName(String name) {
        if (name.isBlank()) {
            String errorMessage = "Название задания не может быть пустым";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return name;
    }

    private int validateDifficulty(int difficulty) {
        if (difficulty < MIN_DIFFICULTY || difficulty > MAX_DIFFICULTY) {
            String errorMessage = "Сложность задания должна быть от " + MIN_DIFFICULTY + " до " + MAX_DIFFICULTY;
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return difficulty;
    }

    private int validateReward(int reward) {
        if (reward < MIN_REWARD || reward > MAX_REWARD) {
            String errorMessage = "Опыт выдаваемый за выполнение задания должен быть от " + MIN_REWARD + " до " + MAX_REWARD;
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return reward;
    }

}
