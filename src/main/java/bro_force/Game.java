package bro_force;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
@Getter
@Slf4j
public class Game {
    private static int score = 0;
    private int lives = 15;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private final Random random = new Random();
    private final ExecutorService executor;

    public Game(ExecutorService executor) {
        this.executor = executor;
    }

    public void update() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (chanceDamage()) {
            synchronized (lockLives) {
                lives--;
                log.info("{} персонаж получили урон!", Thread.currentThread().getName());
                gameOver();
            }
        }
        synchronized (lockScore) {
            if (!Thread.currentThread().isInterrupted()) {
                score++;
                log.info("{} персонаж принес очко в команду! сумма = {}", Thread.currentThread().getName(), score);
            }
        }
    }


    private boolean chanceDamage() {
        return random.nextBoolean();
    }

    public void gameOver() {
        if (lives == 0) {
            System.out.println("Игра окончена счет команды: " + score);
            executor.shutdownNow();
        }
    }
}