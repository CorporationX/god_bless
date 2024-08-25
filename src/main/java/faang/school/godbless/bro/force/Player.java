package faang.school.godbless.bro.force;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Player {
    private String name;
    private int lives;
    private boolean isAlive;
    private int score = 0;

    public Player(String name, int lives, boolean isAlive) {
        this.name = name;
        this.lives = lives;
        this.isAlive = isAlive;
    }

    public boolean getAlive() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
