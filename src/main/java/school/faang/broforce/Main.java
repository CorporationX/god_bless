package school.faang.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 20; i++) {
            boolean makePoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.1;

            executorService.submit(() -> game.update(makePoints, lostLife));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
