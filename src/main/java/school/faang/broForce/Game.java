package school.faang.broForce;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class Game {
    private Integer score;
    private Integer lives;

    public void update(boolean isScoreUpped, boolean isEarnedLives) {
        if (isScoreUpped) {
            synchronized (score) {
                score++;
            }
        }
        if (isEarnedLives) {
            synchronized (lives) {
                lives--;
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("гра окончена, набрано количество очков: " + score);
    }
}
