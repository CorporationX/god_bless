package wow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
    }
}
