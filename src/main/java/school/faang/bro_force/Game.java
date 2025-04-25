package school.faang.bro_force;

import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Random random = new Random();
    private final List<Bro> bros = new CopyOnWriteArrayList<>();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean updateGameState(boolean shouldAddScore, boolean shouldDecreaseLives)
            throws IllegalStateException {
        if (bros.isEmpty()) {
            throw new IllegalStateException("No bros available in game");
        }

        Bro bro = bros.get(random.nextInt(bros.size()));
        synchronized (livesLock) {

            if (shouldDecreaseLives && !bro.getAlive()) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                if (bro.getLives() <= 0) {
                    return gameOver();
                }

            }
        }
        synchronized (scoreLock) {
            if (shouldAddScore) {
                bro.setScore(bro.getScore() + 1);
                score++;
            }
        }
        return false;
    }

    public boolean gameOver() {
        System.out.println("Game over with max score: " + score);
        System.out.println("Lost lives: " + lives);
        return true;
    }
}
