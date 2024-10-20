package school.faang.bro_force;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    private final String name;
    private int lives;
    private int score;

    public Player(String name) {
        this.name = name;
        lives = 2;
        score = 0;
    }
}
