package school.faang.bjs2_38824;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;
    private int level;
    private int experience;

    public void boostExperience(int experienceForQuest) {
        experience += experienceForQuest;
    }
}
