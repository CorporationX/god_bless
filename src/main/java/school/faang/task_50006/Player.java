package school.faang.task_50006;

import lombok.Getter;

@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
