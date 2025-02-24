package school.faang.task_49410;


public class Game {
    private int score = 0;
    private int lives = 5;
    private boolean gameOverFlag = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public synchronized void update(boolean lostLive, boolean earnedPoints) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                System.out.println("Увеличение очков. текущий счёт: " + score);
            }
        }

        synchronized (livesLock) {
            if (lostLive) {
                lives--;
                System.out.println("Потеря жизни, текущий счет жизни: " + lives);
            }
            if (lives <= 0 && !gameOverFlag) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        gameOverFlag = true;
        System.out.println("Игра окончена. Итоговый счёт: " + score);
    }

    public boolean isGameOver() {
        return gameOverFlag;
    }
}
