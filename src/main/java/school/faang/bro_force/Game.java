package school.faang.bro_force;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Game {

    private int score;
    private int lives;

    private Object liveLock = new Object();
    private Object scoreLock = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public synchronized void update() {
        synchronized (scoreLock) {
            score--;
            System.out.println("Игрок потерял очки");
        }
        synchronized (liveLock) {
            lives--;
            System.out.println("Игрок потерял жизнь");
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over");
        System.exit(0);
    }
}
