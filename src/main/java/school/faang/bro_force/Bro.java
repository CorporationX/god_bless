package school.faang.bro_force;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bro {

    private String name;
    private int lives;
    private int score = 0;
    private boolean isAlive;

    public Bro(String name, int lives, boolean alive) {
        this.name = name;
        this.lives = lives;
        this.isAlive = alive;
    }
}
