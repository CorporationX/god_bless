package faang.school.godbless.Task_26;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Random;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Game {
    List<Bro> bros;

    final Object lockForScore = new Object();
    final Object lockForLives = new Object();

    int score;
    int lives;

    boolean isBroDead = false;

    public Game(List<Bro> bros) {
        this.bros = bros;
    }

    void update() {
        while (!isBroDead) {
            Bro bro = bros.get(new Random().nextInt(bros.size()));
            if (bro.getAlive()) {
                synchronized (lockForScore) {
                    bro.setScore(bro.getScore() + 1);
                    score++;
                }
            } else {
                synchronized (lockForLives) {
                    bro.setLives(bro.getLives() - 1);
                    lives++;
                    if (bro.getLives() == 0) {
                        gameOver();
                        isBroDead = true;
                    }
                }
            }
            System.out.println(Thread.currentThread() +
                    " " + bro.getName() + " updated. Bro score: " + bro.getScore() + ", Bro lives: " + bro.getLives());
            System.out.println(Thread.currentThread() +
                    " General " + "Score: " + score + ", Lives: " + lives);
        }
    }

    private void gameOver() {
        System.out.println("Game over !");
    }
}
