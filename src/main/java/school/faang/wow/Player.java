package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void getQuestReward(Quest quest) {
        experience += quest.getReward();
    }
}
