package faang.school.godbless.bro_force;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Game {
    private int score;
    private int lives;
    private List<Bro> bros = new ArrayList<>();
    private Object scoresLock = new Object();
    private Object livesLock = new Object();

    public void addBro(Bro bro) {
        bros.add(bro);
    }


    public boolean update() {
        Random random = new Random();
        int randomIndex = random.nextInt(bros.size());
        Bro bro = bros.get(randomIndex);
            if (bro.getDamage() == true) {
                synchronized (livesLock) {
                    bro.setBroLives(bro.getBroLives() - 1);
                    lives++;
                    System.out.println(bro.getName() + "lives - " + bro.getBroLives());
                    if (bro.getBroLives() == 0) {
                        System.out.println("lives lost - " + lives);
                        return gameOver();
                    }
                }
            } else {
                synchronized (scoresLock) {
                    bro.setBroScores(bro.getBroScores() + 1);
                    score++;
                }
            }
        return false;
    }
    private boolean gameOver() {
        System.out.println("BRO DIED");
        System.out.println("scores - " + score);
        return true;
    }
}
