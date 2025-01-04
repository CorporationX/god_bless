package school.faang.task_50078;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int reward) {
        if (reward < 0) {
            throw new IllegalArgumentException("Reward cannot be negative");
        }
        this.experience += reward;
    }
}