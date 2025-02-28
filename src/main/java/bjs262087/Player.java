package bjs262087;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void upgradePlayer(Quest quest) {
        this.setExperience(this.getExperience() + quest.getReward());
    }
}
