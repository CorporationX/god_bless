package faang.school.godbless.broForce;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bro {
    private String name;
    private int lives;
    private boolean alive;
    private int score;

    public Bro(String name, int lives, boolean alive) {
        this.name = name;
        this.lives = lives;
        this.alive = alive;
        this.score = 0;
    }
}
