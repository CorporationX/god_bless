package faang.school.godbless.BJS2_24204;


import lombok.RequiredArgsConstructor;

import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class Game {
    private final ExecutorService executor;
    private final Object scoreLock = new Object();
    private final Object lostLivesLock = new Object();
    private int score = 0;
    private int lostLives = 0;

    public void update(Player player) {
        if (player.isLostOneLives()) {
            System.out.println(player.getName() + " is lost live");
            synchronized (lostLivesLock) {
                lostLives++;
                if (player.getLives() == 0) {
                    gameOver();
                }
            }
            player.setLostOneLives(false);
        }

        if (player.isGetNewPoint()) {
            synchronized (scoreLock) {
                score++;
            }
            System.out.println(player.getName() + " is earn point");
            player.setGetNewPoint(false);
        }
    }

    private void gameOver() {
        System.out.println("Game over!\nYour bro score: " + score + "\nYour bro lost lives: " + lostLives);
        executor.shutdownNow();
    }
}
