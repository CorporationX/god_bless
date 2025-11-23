package school.faang.bro_force;

import lombok.Getter;

/**
 * Проект: god_bless
 * Класс Game
 * Автор: Vital
 */

@Getter
public class Game {

    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private volatile boolean isGameOver = false;

    //Обновление состояния игры
    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isGameOver) {
            return;
        }

        if (isPointsEarned) {
            synchronized (scoreLock) {
                score++;
                System.out.println(Thread.currentThread().getName() + " - Очки: " + score);
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                lives--;
                System.out.println(Thread.currentThread().getName() + " - Жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.println("Игра окончена! Финальный счёт: " + score);
    }
}