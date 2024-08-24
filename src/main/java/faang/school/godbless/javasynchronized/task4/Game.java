package faang.school.godbless.javasynchronized.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int scores = 0;
    private int lives = 0;
    private final List<Bro> bros = new ArrayList<>();
    boolean gameOver = false;

    private final Object lockScores = new Object();
    private final Object lockLives = new Object();
    private final Random random = new Random();

    public List<Bro> getBros() {
        return bros;
    }

    public void addBros(List<Bro> bros) {
        this.bros.addAll(bros);
    }

    public void update() {
        synchronized (lockLives) {
            if (!gameOver) {
                int indexBro = random.nextInt(bros.size());
                attack(bros.get(indexBro));
            }
        }
   }

    private void attack(Bro bro) {
        bro.getDamage();
        synchronized (lockScores) {
            scores++;
        }
        synchronized (lockLives) {
            if (bro.getLives() <= 0) {
                gameOver = true;
            }
            lives++;
        }
        System.out.println(bro.getName() + " " + bro.getLives());
        if (gameOver) {
            gameOver();
        }
    }

    private void gameOver() {
            System.out.println("Завершение игры");
            System.out.println("Количество набранных очков за игру всеми участниками: " + scores);
            System.out.println("Количество потерянных всеми участниками жизней " + lives);
    }
}
