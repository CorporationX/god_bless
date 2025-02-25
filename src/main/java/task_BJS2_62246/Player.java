package task_BJS2_62246;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int reward) {
        experience += reward;
    }
}
