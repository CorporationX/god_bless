package school.faang.BJS2_62127;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {

    private final String name;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        setLevel(1);
        setExperience(0);
    }
}
