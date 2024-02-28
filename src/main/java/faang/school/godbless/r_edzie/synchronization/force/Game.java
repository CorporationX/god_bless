package faang.school.godbless.r_edzie.synchronization.force;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private final Random random = new Random();

    private int score;
    private int lives;

    private List<Bro> bros = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private boolean isOver = false;

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public void update() {
        int broIndex = random.nextInt(bros.size());
        Bro bro = bros.get(broIndex);
        boolean isAlive = bro.getAlive();

        if (!isAlive) {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;

                if (bro.getLives() <= 0) {
                    gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                bro.setScore(bro.getScore() + 1);
                score++;
            }
        }
    }

    public void gameOver() {
        System.out.println("Game over");
        System.out.println("Total score: " + score);
        isOver = true;
    }
}
