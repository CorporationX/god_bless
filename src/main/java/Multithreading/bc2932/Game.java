package Multithreading.bc2932;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Random random = new Random();
    private int score;
    private int lives;
    List<Bro> bros = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int broIndex = random.nextInt(bros.size());
        Bro bro = bros.get(broIndex);
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

    private boolean gameOver() {
        System.out.println("Max scores: " + score);
        System.out.println("Lost lives: " + lives);
        return true;
    }


}
