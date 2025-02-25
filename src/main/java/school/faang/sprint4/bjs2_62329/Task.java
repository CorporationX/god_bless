package school.faang.sprint4.bjs2_62329;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Task(@NonNull String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
