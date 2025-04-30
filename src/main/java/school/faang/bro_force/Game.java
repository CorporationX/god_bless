package school.faang.bro_force;

import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Game {
    private volatile int score;
    private volatile int lives;
    private final Object gameStateLock = new Object();
    private final Random random = new Random();
    private final List<Bro> bros = new CopyOnWriteArrayList<>();

    public void addBro(Bro bro) {
        if (bro == null) {
            throw new IllegalArgumentException("Bro cannot be null");
        }
        bros.add(bro);
    }

    public boolean updateGameState(boolean shouldAddScore, boolean shouldDecreaseLives)
            throws IllegalStateException {
        if (bros.isEmpty()) {
            throw new IllegalStateException("Cannot update game state: no bros available in game");
        }

        Bro bro;
        synchronized (gameStateLock) {
            bro = bros.get(random.nextInt(bros.size()));
        }

        boolean isGameOver = false;

        if (shouldDecreaseLives) {
            synchronized (gameStateLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                if (bro.getLives() <= 0) {
                    isGameOver = gameOver();
                }
            }
        }

        if (shouldAddScore && !isGameOver) {
            synchronized (gameStateLock) {
                bro.setScore(bro.getScore() + 1);
                score++;
            }
        }

        return isGameOver;
    }

    public boolean gameOver() {
        System.out.println("Game over with max score: " + score);
        System.out.println("Lost lives: " + lives);
        return true;
    }
}
