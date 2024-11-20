package faang.school.godbless.bro_force;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private List<Bro> bros = new ArrayList<>();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    @SneakyThrows
    public boolean update() {
        Bro bro = bros.get(new Random().nextInt(bros.size()));
        boolean isDied = bro.isDied();

        if (!isDied) {
            synchronized (livesLock) {
                System.out.println(Thread.currentThread().getName() + " мочит - " + bro.getName() + " hp = " + bro.getLives());
                bro.setLives(bro.getLives() - 1);
                lives++;

                if (bro.getLives() == 0) {
                    bro.setDied(true);
                    return gameOver(bro);
                }
            }
        } else {
            synchronized (scoreLock) {
                score++;
            }
        }
        return false;
    }

    private boolean gameOver(Bro bro) {
        System.out.println("Game over! " + bro.getName() + " - died");
        return true;
    }
}
