package faang.school.godbless.broForce;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private int score;
    private int lives;

    private List<Bro> bros = new ArrayList<>();
    private Random rand = new Random();

    private Object scoreLock = new Object();
    private Object livesLock = new Object();

    public void update() {
        Bro bro = bros.get(rand.nextInt(bros.size()));
        if (!bro.isAlive()) {
            synchronized (livesLock) {
                lives++;
                bro.setLives(bro.getLives() - 1);
                if (bro.getLives() == 0) {
                    System.out.println(bro.getName() + " dead");
                    gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                score++;
                bro.setScore(bro.getScore() + 1);
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over");
        System.out.println("Score: " + score);
        System.out.println("Lives: " + lives);
    }

    public void addBro(Bro bro) {
        bros.add(bro);
    }
}
