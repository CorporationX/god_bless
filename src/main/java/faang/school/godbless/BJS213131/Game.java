package faang.school.godbless.BJS213131;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Game {

    public List<Gamer> createGamers() {
        return List.of(
                new Gamer("Rambro"),
                new Gamer("Indiana Brones"),
                new Gamer("Brade"),
                new Gamer("Bro Dredd")
        );
    }

    public void update(Gamer gamer, ExecutorService executor) {
        Random randomAction = new Random();
        try {
            while (!gamer.checkDeathGamers()) {
                if (randomAction.nextInt(2) == 1) {
                    Thread.sleep(1000);
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    } else if (!gamer.checkDeathGamers()) {
                        gamer.killEnemy();
                    }
                } else if (gamer.isAlive()) {
                    Thread.sleep(1000);
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    } else if (!gamer.checkDeathGamers()) {
                        gamer.takeDamage();
                        if (gamer.checkDeathGamers()) {
                            executor.shutdownNow();
                            gameOver(executor, gamer);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Update was interrupted");
        }

    }

    private void gameOver(ExecutorService executor, Gamer gamer) throws InterruptedException {
        synchronized (Gamer.class) {
            if (gamer.checkDeathGamers()) {
                executor.shutdownNow();
                System.out.println("GAME OVER! Thanks " + gamer.getName());
            }
        }
    }
}
