package school.faang.BJS2_38548_WOW;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void updateExperience(int experience) {
        this.experience += experience;
    }
}
