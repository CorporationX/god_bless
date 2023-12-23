package faang.school.godbless.bro_forse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Player {
    private String name;
    private int lives;
    private int score = 0;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean isAlive() {
        return lives > 0;
    }
}
