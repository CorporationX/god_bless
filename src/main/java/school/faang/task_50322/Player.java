package school.faang.task_50322;

import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(int amount) {
        this.experience += amount;
    }

}
