package school.faang.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameRunnable {
    public static void main(String[] args) {
        Game game = new Game();
        int players = 3;
        ExecutorService executor = Executors.newFixedThreadPool(players);
        int rounds = 10;
        for (int round = 0; round < rounds; round++) {
            executor.submit(() -> {
                boolean point = Math.random() < 0.5;
                boolean life = Math.random() < 0.5;
                game.update(point, life);
            });
        }
        executor.shutdown();
    }
}
