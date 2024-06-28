package faang.school.godbless.Task27_WoW;

import lombok.Getter;

@Getter
public class Quest {
    private String name;
    private int difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        if (name.isBlank() || difficulty <= 0 || reward <= 0) throw new IllegalArgumentException("invalid arg(s)");
        else {
            this.name = name;
            this.difficulty = difficulty;
            this.reward = reward;
        }
    }

}
