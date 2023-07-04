package faang.school.godbless.multithreading.bro_force;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;

@Getter
public class Game {
    private final Random random;
    private final List<Bro> bros;
    private int lives;
    private int score;
    private final Object livesLock;
    private final Object scoreLock;

    public Game() {
        livesLock = new Object();
        scoreLock = new Object();
        random = new Random();
        bros = new ArrayList<>();
    }

    public boolean update() {
        Bro bro = getRandomBro();
        boolean isAliveAfterFight = bro.isAliveAfterFight();

        if (!isAliveAfterFight) {
            synchronized (livesLock) {
                bro.decreaseLives();
                lives++;
                System.out.println(bro.getName() + " Killed, lives: " + bro.getLives());
                if (bro.getLives() == 0) {
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                bro.increaseScore();
                score++;
            }
        }
        return false;
    }

    private boolean gameOver() {
        System.out.printf("Game over\nTotal score: %d\nLost lives: %d\n", score, lives);
        return true;
    }

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    private Bro getRandomBro() {
        return bros.get(random.nextInt(bros.size()));
    }
}
