package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Game {
    private int score;
    private int lives;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();


    public void update(boolean isScoreUpdated, boolean isLifeLost) {
        if (isScoreUpdated) {
            synchronized (lockScore) {
                score++;
                System.out.println("Очки заработаны. Общий счет " + score);

            }
        }

        if (isLifeLost) {
            synchronized (lockLives) {
                lives--;
                System.out.println("Вы потеряли жизнь. Оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }

            }
        }

    }

    public void gameOver() {
        System.out.println("Игра окончена, вы мертвы. Счет: " + score);
    }

}

