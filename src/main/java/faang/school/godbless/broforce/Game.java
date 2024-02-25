package faang.school.godbless.broforce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private int score;
    private int lives;
    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    private List<Bro> bros = new ArrayList<>();
    Random rnd = new Random();
    private boolean isRunning = true;

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int index = rnd.nextInt(bros.size());
        Bro bro = bros.get(index);
        boolean isWinner = bro.isWinner();
        if (!isWinner) {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                if (bro.getLives() == 0) {
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                score++;
                bro.setScore(bro.getScore() + 1);
                System.out.println(bro.getName() + " score: " + bro.getScore());
            }
        }
        return false;
    }

    private boolean gameOver() {
        System.out.println("Game over!");
        System.out.println("Score is: " + score);
        System.out.println("Lost lives = " + lives);
        isRunning = false;
        return true;
    }
}
