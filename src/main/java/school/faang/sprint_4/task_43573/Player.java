package school.faang.sprint_4.task_43573;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;

    public void increaseExperience(int experience) {
        this.experience += experience;
    }
}
