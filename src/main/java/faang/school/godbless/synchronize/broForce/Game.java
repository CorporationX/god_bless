package faang.school.godbless.synchronize.broForce;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Game {
    private long lives;

    private List<Bro> bros;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(List<Bro> bros) {
        this.bros = bros;
        this.lives = bros.stream().filter(Bro::isAlive).count();
    }

    public void update() {
        while (lives > 1) {
            for (Bro bro : bros) {
                if (bro.isAlive()) {
                    boolean isWin = new Random().nextInt(100) % 2 == 0;
                    if (isWin) {
                        synchronized (scoreLock) {
                            bro.setScore(bro.getScore() + 1);
                            System.out.println(bro.getName() + " score " + bro.getScore());
                        }
                    } else {
                        synchronized (livesLock) {
                            bro.setLives(bro.getLives() - 1);
                            if (bro.getLives() <= 0) {
                                gameOver(bro);
                                bro.setAlive(false);
                                lives--;
                            }
                        }
                    }
                }
            }
        }

        Bro winner = bros.stream().filter(Bro::isAlive).findFirst().orElseThrow();

        System.out.println(winner.getName() + " is the winner with " + winner.getScore() + " points");
    }

    private void gameOver(Bro bro) {
        System.out.println(bro.getName() + " game over with " + bro.getScore() + " points");
    }
}
