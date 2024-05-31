package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor

@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }
}
