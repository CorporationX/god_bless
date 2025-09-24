package school.faang.multithreading.synchronize.bjs2_90127;

import java.util.Random;

public class Game {
    private static int score = 4;
    private static int lives = 5;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Random random = new Random();

    public void update() {
        synchronized (livesLock) {
            if (lives <= 0) {
                gameOver();
                return;
            }
            if (random.nextInt() % 2 != 0) {
                lives--;
                System.out.printf("Количество жизней уменьшилось.\nНовое значение = %d%n", lives);
            }
        }

        synchronized (scoreLock) {
            if (random.nextInt() % 2 == 0) {
                score++;
                System.out.printf("Количество очков увеличилось.\nНовое значение = %d%n", score);
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра завершена проигрышем");
    }
}