package school.faang.naughtwoBJS261799;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                boolean earnedPoints = Math.random() > 0.5; // 50% шанс заработать очки
                boolean lostLife = Math.random() > 0.7;     // 30% шанс потерять жизнь
                game.update(earnedPoints, lostLife);
            });
        }
        executor.shutdown();
    }
}

