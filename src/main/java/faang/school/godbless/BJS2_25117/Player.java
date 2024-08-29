package faang.school.godbless.BJS2_25117;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
