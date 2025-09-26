package school.faang.bjs2_92878;

import lombok.Getter;

@Getter
public class Task {
    private final String name;
    private final Difficult difficult;
    private final int reward;

    public Task(String name, Difficult difficult) {
        this.name = name;
        this.difficult = difficult;
        this.reward = difficult.getDifficultLevelPoints() * 2;
    }
}
