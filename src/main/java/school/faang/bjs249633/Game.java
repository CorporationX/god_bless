package school.faang.bjs249633;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public boolean update(boolean isEarnedPoints, boolean isLostLife) {
        if (isEarnedPoints) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
        }
        if (isLostLife) {
            synchronized (livesLock) {
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                    return false;
                }
            }
        }
        return true;
    }

    private void gameOver() {
        System.out.println("Игра окончена! Все жизни потеряны.");
    }
}
