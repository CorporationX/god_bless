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

    public void update(boolean gainedScore, boolean lostLife) {
        synchronized (this) {
            if (!gameRunning) {
                return;
            }

            if (gainedScore) {
                score++;
                System.out.println(Thread.currentThread().getName() + " + очко. Текущий счет " + score);
            }

            if (lostLife) {
                lives--;
                System.out.println(Thread.currentThread().getName() + " - жизнь! Осталось жизней " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private synchronized void gameOver() {
        if (!gameRunning) {
            return;
        }
        gameRunning = false;
        System.out.println("WASTED Финальный счет: " + score);
    }
}
