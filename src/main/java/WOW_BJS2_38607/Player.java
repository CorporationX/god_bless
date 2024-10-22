package WOW_BJS2_38607;

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void getReward(int reward) {
        this.experience += reward;
    }
}