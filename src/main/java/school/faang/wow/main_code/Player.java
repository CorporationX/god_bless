package school.faang.wow.main_code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int lvl;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
