package school.faang.BJS2_38885;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public void addExperience(int reward) {
        this.experience += reward;
    }
}
