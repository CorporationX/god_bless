package school.faang.BJS2_63823;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Getter
@Slf4j
public class Game {
    private int score;
    private volatile int lives;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean isScore, String name) {
        Objects.requireNonNull(name, "name can't be nll");

        if (isScore) {
            synchronized (lockScore) {
                score++;
                System.out.printf("%nИгрок %s заработал очки. Общий счёт: %d", name, score);
            }
        } else {
            synchronized (lockLives) {
                lives--;
                System.out.printf("%nИгрок %s потерял жизнь. Осталось жизней: %d", name, lives);

                if (lives == 0) {
                    gameOver();
                }
            }
        }

        try {
            Thread.sleep(1000);
        }  catch (InterruptedException e) {
            log.error("Игра не завершена.", e);
            Thread.currentThread().interrupt();
        }
    }

    public void gameOver() {
        System.out.println("\n🎮 Game Over!");
    }

}
