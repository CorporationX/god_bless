package school.faang.task_62116;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int experience) {
        this.experience += experience;
    }
}
