package school.faang.multithreading.synchronize.bjs2_90127;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Game {
    private static int score = 4;
    private static int lives = 5;
    private final Object scoreLock;
    private final Object livesLock;
    private final Random random = new Random();

    public void update() {
        synchronized (livesLock) {
            if (lives <= 0) {
                gameOver();
                return;
            }
        }

        synchronized (scoreLock) {
            if (random.nextInt() % 2 == 0) {
                score++;
                System.out.printf("Количество очков увеличилось.\nНовое значение = %d%n", score);
            }
        }

        synchronized (livesLock) {
            if (random.nextInt() % 2 != 0) {
                lives--;
                System.out.printf("Количество жизней уменьшилось.\nНовое значение = %d%n", lives);
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра завершена проигрышем");
    }
}