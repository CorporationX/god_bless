package faang.school.godbless.BJS2_24095;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Random rand = new Random();
    private int score;
    private int lives;
    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    @Getter
    private List<Bro> bros = new ArrayList<>();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int broIndex = rand.nextInt(bros.size());
        Bro bro = bros.get(broIndex);
        boolean isAlive = bro.getAlive();
        if (!isAlive) {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                System.out.println(bro.getName() + " current lives = " + bro.getLives());
                if (bro.getLives() == 0) {
                    bro.setAlive(false);
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
        System.out.println("Game over with max score: " + score);
        System.out.println("Lost lives: " + lives);
        return true;
    }

    public boolean anyOneDead() {
        long count = bros.stream()
                .filter(bro -> !bro.isAlive())
                .count();
        return count > 0;
    }
}
