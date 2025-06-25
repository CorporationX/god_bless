package school.faang.bjs2_82245;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void gainExperience(int amount) {
        experience += amount;
    }
}
