package school.faang.bjs249633;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public boolean update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
        }

        // Блокировка доступа к жизням
        synchronized (livesLock) {
            if (lostLife) {
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
