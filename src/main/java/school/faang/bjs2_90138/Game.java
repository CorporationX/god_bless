package school.faang.bjs2_90138;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@RequiredArgsConstructor
public class Game {
    Random random = new Random();

    boolean isAlive = random.nextBoolean();

    private int score = 0;
    private int lives = 0;
    private List<Bro> bros = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int broIndex = random.nextInt(bros.size());
        Bro bro = bros.get(broIndex);
        boolean isAlive = bro.isAlive();

        if (!isAlive) {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                System.out.println(bro.getName() + " has " + bro.getLives() + " lives");
                if (bro.getLives() == 0) {
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                bro.setScore(bro.getScore() + 1);
                score++;
                System.out.println(bro.getName() + " scores a point");
            }
        }
        return false;
    }

    public boolean gameOver() {
        System.out.println("Game over with score: " + score);
        System.out.println("Lost lives: " + lives);
        return true;
    }
}
