package faang.school.godbless.BJS213131;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Gamer {
    @Getter
    private static int scoreTotal;
    @Getter
    private static int livesTotal;
    private int score;
    private int lives;
    @Getter
    private String name;
    private boolean isAlive;

    public Gamer(String name) {
        isAlive = true;
        this.name = name;
        lives += 3;
        synchronized (Gamer.class) {
            livesTotal += 3;
        }
    }

    public synchronized void killEnemy() throws InterruptedException {
        if (!isAlive) {
            System.out.println("Gamer " + name + " already dead");
            return;
        }
        Thread.sleep(1000);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        score += 1;
        synchronized (Gamer.class) {
            scoreTotal += 1;
            System.out.println("Gamer " + name + " kill enemy. Now he has " + score + " scores");
            System.out.println("Total scores: " + scoreTotal);
        }
    }

    public synchronized boolean isGameContinueAfterDeath(ExecutorService executor) throws InterruptedException {
        if (!isAlive) {
            System.out.println("Gamer " + name + " already dead");
        } else {
            Thread.sleep(1000);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            lives -= 1;
            synchronized (Gamer.class) {
                livesTotal -= 1;
                System.out.println("Gamer " + name + " killed by enemy. Now he has " + lives + " lives");
                System.out.println("Total lives: " + livesTotal);

                if (lives == 0) {
                    System.out.println("GAME OVER! Thanks " + name);
                    executor.shutdownNow();
                    try {
                        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                            System.out.println("Not all tasks terminated");
                            executor.shutdownNow();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Thread interrupted while finishing game");
                    }
                    return false;
                }
            }

        }
        return true;
    }
}
