package faang.school.godbless.BJS2_24188;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    Random random = new Random();

    private int score;
    private int lives;

    private final List<Bro> bros = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int indexBro = random.nextInt(bros.size());
        Bro bro = bros.get(indexBro);
        boolean isAlive = bro.getAlive();

        if (!isAlive) {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                System.out.println(bro.getName() + " lives: " + bro.getLives());
                if (bro.getLives() == 0) {
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
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
