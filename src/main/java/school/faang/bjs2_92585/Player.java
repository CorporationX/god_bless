package school.faang.bjs2_92585;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player addExperience(int reward) {
        return new Player(this.name, this.level, this.experience + reward);
    }
}
