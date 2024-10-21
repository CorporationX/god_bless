package school.faang.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int PLAYERS_AMOUNT = 4;
        ExecutorService players = Executors.newFixedThreadPool(PLAYERS_AMOUNT);
        Game game = new Game();

        players.submit(() -> {
            while (game.isPlaying()) {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLives = Math.random() > 0.75;
                game.update(earnedPoints, lostLives);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        players.shutdown();
    }
}
