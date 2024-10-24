package school.faang.Sprints.Multithreading_Async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void updateExperience(Quest quest){
        experience += quest.getReward();
    }
}
