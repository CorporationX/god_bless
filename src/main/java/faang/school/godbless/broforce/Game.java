package faang.school.godbless.broforce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Getter
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final List<Bro> bros = new ArrayList<>();
    private final Random random = new Random();
    private int activePlayersCounter = 0;
    private boolean isGameOver = false;

    public void addBro(Bro bro) {
        bros.add(bro);
        activePlayersCounter++;
    }

    public void update() {
        if (isGameOver) {
            return;
        }
        Bro bro = getRandomBro();
        increaseLives(bro);
        increaseScore(bro);
    }

    private void increaseLives(Bro bro) {
        synchronized (livesLock) {
            if (bro.isAlive() && !isGameOver) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                System.out.println(bro.getName() + " lives: " + bro.getLives());
                if (bro.getLives() == 0) {
                    bro.setAlive(false);
                    activePlayersCounter--;
                    gameOver();
                }
            }
        }
    }

    private void increaseScore(Bro bro) {
        synchronized (scoreLock) {
            if (bro.isAlive() && !isGameOver) {
                bro.setScore(bro.getScore() + 1);
                score++;
                System.out.println(bro.getName() + " earned score: " + bro.getScore());
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.printf("Game over with max score %d\n", score);
        System.out.printf("Lost lives %d\n", lives);
    }

    private Bro getRandomBro() {
        if (!bros.isEmpty()) {
            return bros.get(random.nextInt(bros.size()));
        } else {
            throw new NoSuchElementException("No bro found");
        }
    }
}