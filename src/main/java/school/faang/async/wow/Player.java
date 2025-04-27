package school.faang.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public void addExperience(int reward) {
        this.experience += reward;
    }
}
