package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
