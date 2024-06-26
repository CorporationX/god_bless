package faang.school.godbless.BJS2_13816;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void upExperience(int experience) {
        this.experience += experience;
    }
}
