package WOW;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Player {
    private String name;
    private int level;
    private int experience;
    private final int EXPERIENCE_FOR_NEW_LEVEL = 500;

    public void levelUp(int experience) {
        int newExperience = experience + this.experience;
        if (newExperience >= EXPERIENCE_FOR_NEW_LEVEL) {
            System.out.println(this.name + " Level Up!");
            this.level++;
            this.experience = newExperience - EXPERIENCE_FOR_NEW_LEVEL;
        } else {
            this.experience = newExperience;
        }
    }
}
