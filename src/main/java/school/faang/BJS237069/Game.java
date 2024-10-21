package school.faang.BJS237069;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean earnPoints, boolean lostLives) {
        synchronized (scoreLock) {
            if (earnPoints) {
                score++;
                System.out.println("Заработано 1 очко!");
            }
        }
        synchronized (livesLock) {
            if (lostLives) {
                lives--;
                System.out.println("Потеряна 1 жизнь, осталось - " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }

    }

    private void gameOver() {
        System.out.println("Жаль, но ты проиграл!");
    }
}
