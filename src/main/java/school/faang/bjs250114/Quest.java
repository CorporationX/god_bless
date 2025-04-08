package school.faang.bjs250114;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Quest {
    private String name;
    private int difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        if (name == null || name.trim().isEmpty()) {
            log.error("Name cannot be null or empty");
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (difficulty < 0 || reward < 0) {
            log.error("Difficulty or Reward cannot be negative");
            throw new IllegalArgumentException("Difficulty or Reward cannot be negative");
        }
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
