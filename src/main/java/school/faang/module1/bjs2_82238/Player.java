package school.faang.module1.bjs2_82238;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public void updateExperience(int reward) {
        this.experience +=reward;
    }
}