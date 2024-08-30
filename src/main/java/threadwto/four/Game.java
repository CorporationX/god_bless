package threadwto.four;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update() {
        if (lives <= 0) {
            System.out.println("The game has not started. Life counter: " + lives);
            return;
        }
        synchronized (lockScore) {
            score++;
            System.out.println("Score increased: " + score);
        }
        synchronized (lockLives) {
            lives--;
            System.out.println("Life counter reduced: " + lives);
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over. Final score: " + score);
    }
}
