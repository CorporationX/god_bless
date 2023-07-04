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

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
        random = new Random();
    }

    public void increaseScore() {
        this.score++;
    }

    public void decreaseLives() {
        if (lives > 0) {
            lives--;
        }
    }

    public boolean isAliveAfterFight() {
        return random.nextBoolean();
    }
}
