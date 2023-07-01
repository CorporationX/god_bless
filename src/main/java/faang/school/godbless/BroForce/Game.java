package faang.school.godbless.BroForce;

import lombok.Data;

import java.util.Random;
@Data
public class Game {
    private int score;
    private int lives = 100;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(int i) {
        if (new Random().nextBoolean()) {
            synchronized (scoreLock) {
                if (lives >= 1) {
                    lives--;
                    System.out.println("Score: " + score + "| Lives: " + lives);
                } else {
                    gameOver();
                }
            }
        } else {
            synchronized (livesLock) {
                score++;
                System.out.println("Score: " + score + "| Lives: " + lives);
            }
        }
        System.out.println("Round #" + i + "\n");
    }

    private void gameOver() {
        System.out.println("Game over");
    }
}
