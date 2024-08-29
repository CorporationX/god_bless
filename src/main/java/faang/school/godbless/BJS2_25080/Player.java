package faang.school.godbless.BJS2_25080;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int experience) {
        this.experience += experience;
        if (this.experience >= 1000) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        experience -= 1000;
    }
}
