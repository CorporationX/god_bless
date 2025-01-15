package school.faang.sprint4.task_50254;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    private String name;
    private int level;
    private int experience;

    public void addXp(int xp) {
        this.experience += xp;
    }
}
