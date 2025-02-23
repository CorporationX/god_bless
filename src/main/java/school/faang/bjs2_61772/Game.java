package school.faang.bjs2_61772;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Game {
    private int score = 0;
    private int lives = 10;
    private boolean isGameOver;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScoreUp, boolean isLivesLost) {
        if (isGameOver) {
            return;
        }
        if (isScoreUp) {
            synchronized (scoreLock) {
                score++;
                System.out.printf("Очки увеличены, общий счет очков: %d\n", score);
            }
        }
        if (isLivesLost) {
            synchronized (livesLock) {
                lives--;
                System.out.printf("Жизни уменьшены, общий показатель жизней: %d\n", lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.printf("GAME OVER! Общий счет очков: %d%n", score);

    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
