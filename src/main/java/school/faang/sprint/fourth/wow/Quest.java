package school.faang.sprint.fourth.wow;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Quest {
    @NonNull
    private String name;
    private int difficulty;
    private int reward;

    public Quest(@NonNull String name, int difficulty, int reward) {
        validateData(name, difficulty, reward);
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    private void validateData(@NonNull String name, int difficulty, int reward) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (difficulty <= 0) {
            throw new IllegalArgumentException("Difficulty must be greater than 0.");
        }
        if (reward <= 0) {
            throw new IllegalArgumentException("Reward must be greater than 0.");
        }
    }
}
