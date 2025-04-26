package school.faang.bro_force;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Game {

    private int score = 0;
    private int lives = 5;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean isGameOver = true;

    public void update(boolean isScorePoints, boolean isLosesLives) {
        if (!isGameOver) {
            return;
        }
        if (isScorePoints) {
            synchronized (scoreLock) {
                score++;
                System.out.printf("игрок увеличил очки на  %d \n", score);
                if (score == 10) {
                    System.out.println("win");
                    isGameOver = false;
                    return;
                }
            }
        }

        if (isLosesLives) {
            synchronized (livesLock) {
                lives--;
                System.out.printf("игрок теряет прочность на  %d \n", lives);
                if (lives == 0) {
                    System.out.println("Game Over");
                    isGameOver = false;
                    return;
                }
            }
        }
    }


}
