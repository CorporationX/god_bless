package school.faang.task_63915;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public synchronized int addExperience(int experience) {
        return this.experience += experience;
    }
}
