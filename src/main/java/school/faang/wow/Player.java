package school.faang.wow;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    @Setter
    private static int experiencePerLevel = 1000;

    @Setter
    private String name;
    private int experience;
    private int level;

    public Player(String name) {
        this.name = name;
    }

    public void addExperience(int experience) {
        int experienceAfterQuest = this.experience + experience;
        this.experience = experienceAfterQuest % experiencePerLevel;
        this.level += experienceAfterQuest / experiencePerLevel;
    }
}
