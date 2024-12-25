package school.faang.task_50026;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Quest {

    private String name;
    private int difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        if (name == null || name.isEmpty()) {
            log.error("name is null or empty");
            throw new IllegalArgumentException("name is null or empty");
        }
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}