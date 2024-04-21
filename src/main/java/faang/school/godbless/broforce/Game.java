package faang.school.godbless.broforce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {

    private int score;
    private int lives;
    private List<Bro> bros = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int broIndex = new Random().nextInt(bros.size());
        Bro bro = bros.get(broIndex);
        boolean alive = bro.getAlive();

        if (!alive) {
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

    private boolean gameOver() {
        System.out.println("Game over, with max score: " + score);
        System.out.println("Lost lives: " + lives);
        return true;
    }
}
