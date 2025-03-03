package school.faang.task_62236;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public synchronized void addExperience(int amount) {
        this.experience += amount;
    }
}
