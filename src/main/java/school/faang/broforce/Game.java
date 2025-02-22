package school.faang.broforce;

public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            synchronized (scoreLock) {
                score++;
                System.out.printf("Очки увеличены, текущий счёт: %d\n", score);
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                lives--;
                System.out.printf("Жизни уменьшены, оставшиеся жизни: %d\n", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("Игра окончена! Финальный счет: %d\n", score);
        System.exit(0);
    }
}