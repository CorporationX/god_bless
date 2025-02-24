package school.faang.sprint4.bjs2_63654;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Quest(@NonNull String name, int difficulty, int reward) {
        if (name.isBlank()) {
            String errorMessage = "Название задания не может быть пустым";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        if (difficulty < 1 || difficulty > 3) {
            String errorMessage = "Сложность задания должна быть от 1 до 3";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        if (reward < 1 || reward > 100) {
            String errorMessage = "Опыт выдаваемый за выполнение задания должен быть от 1 до 100";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
