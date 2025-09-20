package school.faang.bjs2_90111;

public class Game {
    private int score = 0;
    private int lives = 3;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean gainedPoint, boolean lostLife) {
        synchronized (scoreLock) {
            if (gainedPoint) {
                score++;
                System.out.printf("%s: Очко! Счет: %d%n",
                        Thread.currentThread().getName(), score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.printf("%s: Потеряна жизнь! Осталось: %d%n",
                        Thread.currentThread().getName(), lives);

                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("ИГРА ОКОНЧЕНА! Финальный счет: %d%n", score);
    }

    public int getScore() {
        synchronized (scoreLock) {
            return score;
        }
    }

    public int getLives() {
        synchronized (livesLock) {
            return lives;
        }
    }
}