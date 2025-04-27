package school.faang.bjs273649;

import lombok.Getter;

public class Game {
    private int score;
    private int lives;
    @Getter
    private boolean gameRunning = true;

    public Game(int initialLives) {
        this.score = 0;
        this.lives = initialLives;
    }

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean gainedScore, boolean lostLife) {
        if (!gameRunning) {
            return;
        }

        if (gainedScore) {
            synchronized (scoreLock) {
                score++;
                System.out.println(Thread.currentThread().getName() + " + очко. Текущий счет " + score);
            }
        }

        if (lostLife) {
            synchronized (livesLock) {
                lives--;
                System.out.println(Thread.currentThread().getName() + " - жизнь! Осталось жизней " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        gameRunning = false;
        System.out.println("WASTED Финальный счет: " + score);
    }
}
