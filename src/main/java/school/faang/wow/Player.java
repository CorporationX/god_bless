package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private static final int LEVEL_UP_THRESHOLD = 10;
    private final String name;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.level = 0;
        this.experience = 0;
    }

    public void applyRewards(Quest quest) {
        experience += quest.getDifficulty() * quest.getReward();
        while (experience > LEVEL_UP_THRESHOLD) {
            level++;
            experience -= LEVEL_UP_THRESHOLD;
        }
    }
}
