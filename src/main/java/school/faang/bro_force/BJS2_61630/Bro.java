package school.faang.bro_force.BJS2_61630;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bro {
    private final String name;
    private int lives;
    private int score;
    private boolean alive = true;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }
}
