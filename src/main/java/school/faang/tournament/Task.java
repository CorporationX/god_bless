package school.faang.tournament;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Task {

    private String name;
    private Difficulty difficulty;
    private int reward;

    public Task(String name, Difficulty difficulty, int reward) {
        Objects.requireNonNull(difficulty, "Difficulty cannot be null");
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}
