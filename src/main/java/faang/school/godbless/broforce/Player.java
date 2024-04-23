package faang.school.godbless.broforce;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Player {

    private Random random = new Random();

    private String name;
    private int score;
    private int lives;
    private boolean isAlive;

    public Player(String name, int lives, boolean isAlive) {
        this.isAlive = isAlive;
        this.lives = lives;
        this.name = name;
        this.score = 0;
    }

    public boolean getAlive(){
        return random.nextBoolean();
    }
}
