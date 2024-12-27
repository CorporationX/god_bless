package faang.school.godbless.sprint_3.task_49389;

import lombok.Getter;

@Getter
public class Game {
    private int score = 0;
    private int lives;

    private boolean isGameOver = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int lives) {
        checkLives(lives);
        this.lives = lives;
    }

    public void update(boolean isScoreIncreased, boolean isLifeLost) {
        if (isGameOver()) {
            return;
        }

        synchronized (scoreLock) {
            if (isScoreIncreased) {
                score++;
                System.out.println("Счёт увеличен! Текущий счёт: " + score);
            }
        }

        synchronized (livesLock) {
            if (isLifeLost) {
                if (lives < 1) {
                    gameOver();
                    return;
                }
                lives--;
                System.out.println("Жизнь потеряна! Оставшиеся жизни: " + lives);
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена!");
        isGameOver = true;
    }

    private static void checkLives(int lives) {
        if (lives < 1) {
            throw new IllegalArgumentException("Жизней не может быть меньше 1");
        }
    }
}
