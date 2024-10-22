package school.faang.fourthStream.BJS2_38531;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private final String name;
    private double level;
    private int exp;

    public void addExperience(int reward) {
        this.exp += reward;
    }

    public void upgradeLevel(int difficulty) {
        if (difficulty < this.level) {
            this.level += 0.5;
        } else {
            this.level += 1;
        }
    }
}
