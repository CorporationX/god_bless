package school.faang.sprints.sprint4.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {

    private String name;
    private int level;
    private int experience;

    void addExperience(int experience) {
        this.experience += experience;
    }
}
