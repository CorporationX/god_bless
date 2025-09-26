package bjs2_90154;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                if (lives <= 0) {
                    gameOver();
                    return;
                }
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена! Все жизни потеряны. Финальный счёт: " + score);
    }
}