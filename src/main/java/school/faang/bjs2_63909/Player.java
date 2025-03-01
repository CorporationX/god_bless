package school.faang.bjs2_63909;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private String name;
    private int level;
    private int experience;

    public void upgradeExperience(int experience) {
        this.experience += experience;
    }

}
