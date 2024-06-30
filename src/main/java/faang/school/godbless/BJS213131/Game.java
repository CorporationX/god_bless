package faang.school.godbless.BJS213131;

import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Game {
    @Getter
    volatile boolean isActive;

    public List<Gamer> createGamers() {
        isActive = true;
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
            while (isActive) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                if (randomAction.nextInt(2) == 1) {
                    gamer.killEnemy();
                } else if (!gamer.isGameContinueAfterDeath(executor)) {
                    gameOver(executor);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Update was interrupted");
        }

    }

    private void gameOver(ExecutorService executor) {
        synchronized (Gamer.class) {
            isActive = false;
            executor.shutdownNow();
        }
    }
}
