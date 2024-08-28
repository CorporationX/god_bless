package faang.school.godbless.bro_force;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Player {

    private String name;
    private int lives;
    private int score = 0;
    private boolean alive = true;

    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public boolean getAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public boolean isAlive() {
        return alive;
    }
}
