package school.faang.mmorg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
