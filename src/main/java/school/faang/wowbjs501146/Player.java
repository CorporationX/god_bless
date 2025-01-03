package school.faang.wowbjs501146;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int amount) {
        this.experience += amount;
    }
}
