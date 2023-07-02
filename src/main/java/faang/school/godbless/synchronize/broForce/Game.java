package faang.school.godbless.synchronize.broForce;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Game {
    private int score;
    private int lives;

    private List<Bro> bros;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(List<Bro> bros) {
        this.bros = bros;
        this.lives = bros.stream().mapToInt(Bro::getLives).sum();
    }

    public void update() {
        while (lives > 0) {
            for (Bro bro : bros) {
                boolean isWin = new Random().nextBoolean();
                if (isWin) {
                    synchronized (scoreLock) {
                        bro.setScore(bro.getScore() + 1);
                        System.out.println(bro.getName() + " score " + bro.getScore());
                    }
                } else {
                    synchronized (livesLock) {
                        if (bro.getLives() <= 0) {
                            gameOver(bro);
                            return;
                        }
                        bro.setLives(bro.getLives() - 1);
                        lives--;
                    }
                }
            }
        }
    }

    private void gameOver(Bro bro) {
        System.out.println(bro.getName() + " game over with " + bro.getScore() + " points");
    }
}
