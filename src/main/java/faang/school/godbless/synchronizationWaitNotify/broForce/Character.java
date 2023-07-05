package faang.school.godbless.synchronizationWaitNotify.broForce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Character {
    private String name;
    private int score;
    private int lives;

    private final Random random = new Random();

    public boolean isAlive() {
        return random.nextBoolean();
    }

    public void addPoint() {
        this.score++;
    }

    public boolean decrementAndCheckLives() {
        this.lives--;
        return lives == 0;
    }
}
