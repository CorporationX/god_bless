package wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public void completeQuest(Quest quest) {
        this.experience += quest.getReward();
    }
}
