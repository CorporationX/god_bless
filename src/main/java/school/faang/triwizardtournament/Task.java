package school.faang.triwizardtournament;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }


}
