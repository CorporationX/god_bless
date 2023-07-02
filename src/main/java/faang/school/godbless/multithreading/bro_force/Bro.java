package faang.school.godbless.multithreading.bro_force;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bro {
    private Random random;
    private String name;
    private int lives;
    private int score;
    private boolean alive;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
        score = 0;
        alive = true;
        random = new Random();
    }

    public void increaseScore() {
        this.score++;
    }

    public void decreaseLives() {
        if (lives > 0) {
            this.lives--;
        } else {
            this.alive = false;
        }
    }

    public boolean isAliveAfterFight() {
        return random.nextBoolean();
    }
}
