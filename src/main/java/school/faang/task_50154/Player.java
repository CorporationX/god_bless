package school.faang.task_50154;

import lombok.Data;

@Data
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void newExperience(int newPlayExperience) {
        this.experience += newPlayExperience;
    }
}
