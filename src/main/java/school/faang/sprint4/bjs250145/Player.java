package school.faang.sprint4.bjs250145;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int reward) {
        this.experience += reward;
    }
}