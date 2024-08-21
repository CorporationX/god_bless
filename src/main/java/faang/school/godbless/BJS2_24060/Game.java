package faang.school.godbless.BJS2_24060;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class Game {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private int score;
    private int lostLives;
    private final ExecutorService stopGame;

    public void update() {
        synchronized (lock1) {
            System.out.println("Update! Score: " + score);
            score++;
        }
    }

    public void die(Player player) {
        synchronized (lock2) {
            player.die();
            lostLives++;

            if (lostLives == 12) {
                gameOver(player);
            }
        }
    }

    private void gameOver(Player player) {
        stopGame.shutdownNow();

        synchronized (lock1) {
            System.out.println();
            System.out.println(player.getName() + " dead!");
            System.out.println("Total score: " + score);
            System.out.println();

            GeneralStatistics.addNewScore(score);
            GeneralStatistics.addNewLostLives(lostLives);
        }
    }
}
