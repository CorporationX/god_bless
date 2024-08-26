package faang.school.godbless.BJS2_24095;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Bro {
    private int lives;
    private int score = 0;
    private String name;
    private boolean alive = true;

    public Bro(int lives, String name) {
        this.lives = lives;
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean getAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
