package school.faang.bjs2_90111;

import lombok.Getter;

public class Game {
    @Getter
    private int score = 0;
    private int lives = 3;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean gainedPoint, boolean lostLife) {
        if (gainedPoint && lives > 0) {
            synchronized (scoreLock) {
                score++;
                System.out.printf("%s: Очко! Счет: %d%n",
                        Thread.currentThread().getName(), score);
            }
        }

        if (lostLife) {
            synchronized (livesLock) {
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

    public int getLives() {
        synchronized (livesLock) {
            return lives;
        }
    }
}