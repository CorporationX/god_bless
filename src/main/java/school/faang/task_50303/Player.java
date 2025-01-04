package school.faang.task_50303;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(int reward) {
        experience += reward;
        levelUp();
    }

    public void levelUp() {
        level++;
    }
}
