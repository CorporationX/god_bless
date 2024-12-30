package school.faang.task_50174;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public void addExp(Quest quest) {
        experience = experience + quest.getReward();
    }
}
