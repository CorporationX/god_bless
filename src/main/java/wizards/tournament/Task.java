package wizards.tournament;

import lombok.Getter;

@Getter
public class Task {
    private final String name;
    private final int difficulty;
    private final int trophy;

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.trophy = reward;
    }
}
