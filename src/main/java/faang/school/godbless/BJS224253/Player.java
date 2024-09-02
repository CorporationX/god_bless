package faang.school.godbless.BJS224253;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int lives;
    private int score;
    private boolean isAlive = true;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }
}
