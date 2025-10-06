package school.faang.bjs2_92650;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int reward) {
        experience += reward;
    }
}
